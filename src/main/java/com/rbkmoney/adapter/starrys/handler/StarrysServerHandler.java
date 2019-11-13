package com.rbkmoney.adapter.starrys.handler;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.exception.UnsupportedMethodException;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.flow.StepResolver;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.handler.CommonHandler;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.common.Validator;
import com.rbkmoney.adapter.starrys.converter.entry.CtxToEntryModelConverter;
import com.rbkmoney.adapter.starrys.converter.exit.ExitModelToProxyResultConverter;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import com.rbkmoney.adapter.starrys.validator.CashRegContextValidator;
import com.rbkmoney.damsel.cashreg.provider.CashRegContext;
import com.rbkmoney.damsel.cashreg.provider.CashRegProviderSrv;
import com.rbkmoney.damsel.cashreg.provider.CashRegResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class StarrysServerHandler implements CashRegProviderSrv.Iface {

    private final CtxToEntryModelConverter ctxToEntryModelConverter;
    private final ExitModelToProxyResultConverter exitModelToProxyResultConverter;
    private final StepResolver stepResolver;
    private final CashRegContextValidator cashRegContextValidator;
    private final List<CommonHandler<ExitStateModel, FullResponse, EntryStateModel>> handlers;

    @Override
    public CashRegResult register(CashRegContext context) throws TException {
        return handle(
                cashRegContextValidator,
                ctxToEntryModelConverter,
                exitModelToProxyResultConverter,
                context
        );
    }

    private <T, R> R handle(
            Validator<T> validator,
            Converter<T, EntryStateModel> entryConverter,
            Converter<ExitStateModel, R> exitConverter,
            T context
    ) throws TException {
        EntryStateModel entryStateModel = prepareEntryState(validator, entryConverter, context);
        ExitStateModel exitStateModel = handlers.stream()
                .filter(handler -> handler.isHandler(entryStateModel))
                .findFirst()
                .orElseThrow(UnsupportedMethodException::new)
                .handle(entryStateModel);
        exitStateModel.getAdapterContext().setNextStep(stepResolver.resolveExit(exitStateModel));
        return exitConverter.convert(exitStateModel);
    }

    private <T> EntryStateModel prepareEntryState(
            Validator<T> validator,
            Converter<T, EntryStateModel> entryConverter,
            T context
    ) {
        validator.validate(context);
        EntryStateModel entryStateModel = entryConverter.convert(context);
        entryStateModel.getState().getAdapterContext().setNextStep(stepResolver.resolveEntry(entryStateModel));
        return entryStateModel;
    }

//
//    private final StarRysClient client;
//
//    @Override
//    public CashRegResult debit(CashRegContext context) throws TException {
//        String requestId = context.getRequestId();
//        log.info("Start: debit with request_id {}", requestId);
//        try {
//            ResponseEntity<FullResponse> responseEntity = (ResponseEntity<FullResponse>) client.debit(context);
//            Intent intent = getIntent(responseEntity);
//            String originalResponse = Objects.requireNonNull(responseEntity.getBody()).toString();
//            CashRegResult cashRegResult = createCashRegResult(intent, originalResponse);
//            log.info("Finish: debit with request_id {}, response {}", requestId, responseEntity);
//            return cashRegResult;
//        } catch (Exception ex) {
//            log.error("Exception with request_id {}: ", requestId);
//            throw new RuntimeException(ex);
//        }
//    }
//
//    @Override
//    public CashRegResult credit(CashRegContext context) throws TException {
//        throw new TException("Method Credit Not Supported");
//    }
//
//    @Override
//    public CashRegResult refundDebit(CashRegContext context) throws TException {
//        String requestId = context.getRequestId();
//        log.info("Start: refund debit with request_id {}", requestId);
//        try {
//            ResponseEntity<FullResponse> responseEntity = (ResponseEntity<FullResponse>) client.refundDebit(context);
//            Intent intent = getIntent(responseEntity);
//            String originalResponse = Objects.requireNonNull(responseEntity.getBody()).toString();
//            CashRegResult cashRegResult = createCashRegResult(intent, originalResponse);
//            log.info("Finish: refund debit with request_id {}, response {}", requestId, responseEntity);
//            return cashRegResult;
//        } catch (Exception ex) {
//            log.error("Exception with request_id {}: ", requestId);
//            throw new RuntimeException(ex);
//        }
//    }

//    private Intent getIntent(ResponseEntity<FullResponse> response) {
//        Intent intent;
//        if (!hasBody(response)) {
//            intent = createFinishIntentFailure(createFailure(DEFAULT_ERROR_CODE, EMPTY_BODY));
//        } else {
//            FullResponse fullResponse = response.getBody();
//            intent = getIntent(response, fullResponse);
//        }
//        return intent;
//    }
//
//    private Intent getIntent(ResponseEntity<FullResponse> responseEntity, FullResponse response) {
//        Intent intent;
//        if (hasError(response)) {
//            intent = createFinishIntentFailure(createFailure(
//                    response.getResponse().getError().toString(),
//                    String.join(", ", response.getResponse().getErrorMessages())
//            ));
//        } else if (isDelivered(responseEntity)) {
//            intent = createFinishIntentSuccess(preparePayload(response));
//        } else {
//            intent = createFinishIntentFailure(createFailure(DEFAULT_ERROR_CODE, UNKNOWN));
//        }
//        return intent;
//    }
//
//    private static boolean hasBody(ResponseEntity<?> response) {
//        return response.getBody() == null;
//    }
//
//    private static boolean hasError(FullResponse fullResponse) {
//        return (fullResponse.getResponse().getError() != 0 && fullResponse.getResponse().getError() != null);
//    }
//
//    private static Payload preparePayload(FullResponse response) {
//        return new Payload();
//    }
//
//    public boolean isDelivered(ResponseEntity<?> entity) {
//        FullResponse fullResponse = (FullResponse) entity.getBody();
//        return HttpStatus.SC_OK == entity.getStatusCode().value() && fullResponse.getResponse().getError() == 0;
//    }


}
