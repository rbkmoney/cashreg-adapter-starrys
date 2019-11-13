package com.rbkmoney.adapter.starrys.processor;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.AdapterState;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.processor.Processor;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.Response;
import com.rbkmoney.adapter.starrys.utils.ErrorUtils;
import com.rbkmoney.damsel.cashreg.CashRegInfo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SuccessProcessor implements Processor<ExitStateModel, EntryStateModel, FullResponse> {

    private final Processor<ExitStateModel, EntryStateModel, FullResponse> nextProcessor;

    @Override
    public ExitStateModel process(FullResponse fullResponse, EntryStateModel entryStateModel) {
        if (!ErrorUtils.hasError(fullResponse)) {
            ExitStateModel exitStateModel = new ExitStateModel();
            exitStateModel.setEntryStateModel(entryStateModel);

            AdapterState adapterState = entryStateModel.getState().getAdapterContext();
            adapterState.setReceiptId(fullResponse.getRequestId());
            adapterState.setCashRegId(entryStateModel.getCashRegId());

            if(fullResponse.getResponse() != null) {
                Response response = fullResponse.getResponse();
                CashRegInfo cashRegInfo = new CashRegInfo();
                cashRegInfo.setReceiptId(response.getRequestId());
                cashRegInfo.setTimestamp(response.getDateTime().toString());
                cashRegInfo.setFnNumber(response.getFiscalDocNumber().toString());
                cashRegInfo.setTotal(response.getGrandTotal().toString());
                exitStateModel.setCashRegInfo(cashRegInfo);
            }


            exitStateModel.setAdapterContext(adapterState);
            return exitStateModel;
        }

        return nextProcessor.process(fullResponse, entryStateModel);
    }

}