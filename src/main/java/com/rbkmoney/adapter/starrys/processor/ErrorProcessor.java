package com.rbkmoney.adapter.starrys.processor;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.processor.Processor;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import com.rbkmoney.adapter.starrys.utils.ErrorUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import static com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.Error.UNKNOWN;

@Slf4j
@RequiredArgsConstructor
public class ErrorProcessor implements Processor<ExitStateModel, EntryStateModel, ResponseEntity<FullResponse>> {

    @Override
    public ExitStateModel process(ResponseEntity<FullResponse> response, EntryStateModel entryStateModel) {
        ExitStateModel exitStateModel = new ExitStateModel();
        exitStateModel.setEntryStateModel(entryStateModel);
        if (entryStateModel.getState().getAdapterContext() != null) {
            exitStateModel.setAdapterContext(entryStateModel.getState().getAdapterContext());
        }
        if (ErrorUtils.hasError(response)) {
            exitStateModel.setErrorCode(response.getBody().getResponse().getError().toString());
            exitStateModel.setErrorMessage(response.getBody().getResponse().getDescription());
        } else {
            log.error("Unknown result code for response: {}!", response);
            exitStateModel.setErrorCode(UNKNOWN.getCode());
            exitStateModel.setErrorMessage(UNKNOWN.getMessage());
        }
        return exitStateModel;
    }

}
