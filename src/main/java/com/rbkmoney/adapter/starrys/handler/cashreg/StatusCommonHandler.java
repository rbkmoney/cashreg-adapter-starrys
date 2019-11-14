package com.rbkmoney.adapter.starrys.handler.cashreg;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.handler.CommonHandlerImpl;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.Step;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.processor.Processor;
import com.rbkmoney.adapter.starrys.service.starrys.StarRysClient;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.ComplexRequest;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.RequestWrapper;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class StatusCommonHandler extends CommonHandlerImpl<ExitStateModel, RequestWrapper<ComplexRequest>, ResponseEntity<FullResponse>, EntryStateModel> {

    public StatusCommonHandler(
            StarRysClient client,
            Converter<EntryStateModel, RequestWrapper<ComplexRequest>> converter,
            Processor<ExitStateModel, EntryStateModel, ResponseEntity<FullResponse>> responseProcessorChain
    ) {
        super(client::status, converter, responseProcessorChain);
    }

    @Override
    public boolean isHandler(EntryStateModel entryStateModel) {
        return Step.CHECK_STATUS.equals(entryStateModel.getState().getAdapterContext().getNextStep());
    }

}
