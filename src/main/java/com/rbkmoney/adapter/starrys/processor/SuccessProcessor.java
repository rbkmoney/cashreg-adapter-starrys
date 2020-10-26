package com.rbkmoney.adapter.starrys.processor;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterState;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.processor.Processor;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.Response;
import com.rbkmoney.adapter.starrys.utils.ErrorUtils;
import com.rbkmoney.damsel.cashreg.receipt.ReceiptInfo;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class SuccessProcessor implements Processor<ExitStateModel, EntryStateModel, ResponseEntity<FullResponse>> {

    private final Processor<ExitStateModel, EntryStateModel, ResponseEntity<FullResponse>> nextProcessor;

    @Override
    public ExitStateModel process(ResponseEntity<FullResponse> responseEntity, EntryStateModel entryStateModel) {
        if (!ErrorUtils.hasError(responseEntity)) {
            ExitStateModel exitStateModel = new ExitStateModel();
            exitStateModel.setEntryStateModel(entryStateModel);

            AdapterState adapterState = entryStateModel.getState().getAdapterContext();
            FullResponse fullResponse = responseEntity.getBody();
            adapterState.setReceiptId(fullResponse.getRequestId());
            adapterState.setCashregId(entryStateModel.getCashRegId());

            if (isDelivered(responseEntity)) {
                Response response = fullResponse.getResponse();
                ReceiptInfo receiptInfo = new ReceiptInfo()
                        .setReceiptId(response.getRequestId())
                        .setTimestamp(response.getDateTime().toString())
                        .setFnNumber(response.getFiscalDocNumber().toString())
                        .setTotal(response.getGrandTotal().toString());
                exitStateModel.setInfo(receiptInfo);
            }

            exitStateModel.setAdapterContext(adapterState);
            return exitStateModel;
        }

        return nextProcessor.process(responseEntity, entryStateModel);
    }

    public boolean isDelivered(ResponseEntity<FullResponse> entity) {
        FullResponse fullResponse = entity.getBody();
        return HttpStatus.SC_OK == entity.getStatusCode().value() && fullResponse != null && fullResponse.getResponse().getError() == 0;
    }

}