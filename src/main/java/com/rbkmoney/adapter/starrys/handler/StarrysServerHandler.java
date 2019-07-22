package com.rbkmoney.adapter.starrys.handler;

import com.rbkmoney.adapter.starrys.service.starrys.StarRysClient;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import com.rbkmoney.cashreg.proto.provider.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.thrift.TException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.rbkmoney.adapter.starrys.utils.wrapper.cashreg.constant.Error.*;
import static com.rbkmoney.adapter.starrys.utils.wrapper.cashreg.creators.CashRegProviderCreators.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class StarrysServerHandler implements CashRegProviderSrv.Iface {

    private final StarRysClient client;

    @Override
    public CashRegResult debit(CashRegContext context) throws TException {
        String requestId = context.getRequestId();
        log.info("Start: debit with request_id {}", requestId);
        try {
            ResponseEntity<FullResponse> responseEntity = (ResponseEntity<FullResponse>) client.debit(context);
            Intent intent = getIntent(responseEntity);
            String originalResponse = Objects.requireNonNull(responseEntity.getBody()).toString();
            CashRegResult cashRegResult = createCashRegResult(intent, originalResponse);
            log.info("Finish: debit with request_id {}, response {}", requestId, responseEntity);
            return cashRegResult;
        } catch (Exception ex) {
            log.error("Exception with request_id {}: ", requestId);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public CashRegResult credit(CashRegContext context) throws TException {
        throw new TException("Method Credit Not Supported");
    }

    @Override
    public CashRegResult refundDebit(CashRegContext context) throws TException {
        String requestId = context.getRequestId();
        log.info("Start: refund debit with request_id {}", requestId);
        try {
            ResponseEntity<FullResponse> responseEntity = (ResponseEntity<FullResponse>) client.refundDebit(context);
            Intent intent = getIntent(responseEntity);
            String originalResponse = Objects.requireNonNull(responseEntity.getBody()).toString();
            CashRegResult cashRegResult = createCashRegResult(intent, originalResponse);
            log.info("Finish: refund debit with request_id {}, response {}", requestId, responseEntity);
            return cashRegResult;
        } catch (Exception ex) {
            log.error("Exception with request_id {}: ", requestId);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public CashRegResult refundCredit(CashRegContext context) throws TException {
        throw new TException("Method Refund Credit Not Supported");
    }

    @Override
    public CashRegResult getStatus(CashRegContext context) throws TException {
        throw new TException("Method Status Not Supported");
    }

    private Intent getIntent(ResponseEntity<FullResponse> response) {
        Intent intent;
        if (!hasBody(response)) {
            intent = createFinishIntentFailure(createFailure(DEFAULT_ERROR_CODE, EMPTY_BODY));
        } else {
            FullResponse fullResponse = response.getBody();
            intent = getIntent(response, fullResponse);
        }
        return intent;
    }

    private Intent getIntent(ResponseEntity<FullResponse> responseEntity, FullResponse response) {
        Intent intent;
        if (hasError(response)) {
            intent = createFinishIntentFailure(createFailure(
                    response.getResponse().getError().toString(),
                    String.join(", ", response.getResponse().getErrorMessages())
            ));
        } else if (isDelivered(responseEntity)) {
            intent = createFinishIntentSuccess(preparePayload(response));
        } else {
            intent = createFinishIntentFailure(createFailure(DEFAULT_ERROR_CODE, UNKNOWN));
        }
        return intent;
    }

    private static boolean hasBody(ResponseEntity<?> response) {
        return response.getBody() == null;
    }

    private static boolean hasError(FullResponse fullResponse) {
        return (fullResponse.getResponse().getError() != 0 && fullResponse.getResponse().getError() != null);
    }

    private static Payload preparePayload(FullResponse response) {
        return new Payload();
    }

    public boolean isDelivered(ResponseEntity<?> entity) {
        FullResponse fullResponse = (FullResponse) entity.getBody();
        return HttpStatus.SC_OK == entity.getStatusCode().value() && fullResponse.getResponse().getError() == 0;
    }


}
