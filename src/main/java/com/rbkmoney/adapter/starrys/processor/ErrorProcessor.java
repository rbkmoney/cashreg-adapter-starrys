package com.rbkmoney.adapter.starrys.processor;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.processor.Processor;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import com.rbkmoney.adapter.starrys.utils.ErrorUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
@RequiredArgsConstructor
public class ErrorProcessor implements Processor<ExitStateModel, EntryStateModel, ResponseEntity<FullResponse>> {

    @Override
    public ExitStateModel process(ResponseEntity<FullResponse> response, EntryStateModel entryStateModel) {
        ExitStateModel exitStateModel = new ExitStateModel();
        if (ErrorUtils.hasError(response)) {
            exitStateModel.setEntryStateModel(entryStateModel);
        } else {
            log.error("Unknown result code for response: {}!", response);
            exitStateModel.setErrorCode(com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.Error.UNKNOWN.getCode());
            exitStateModel.setErrorMessage(com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.Error.UNKNOWN.getMessage());
        }
        return exitStateModel;
    }

}
