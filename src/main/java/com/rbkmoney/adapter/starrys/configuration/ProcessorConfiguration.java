package com.rbkmoney.adapter.starrys.configuration;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.processor.Processor;
import com.rbkmoney.adapter.starrys.processor.ErrorProcessor;
import com.rbkmoney.adapter.starrys.processor.SuccessProcessor;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ProcessorConfiguration {

    @Bean
    public Processor<ExitStateModel, EntryStateModel, FullResponse> responseProcessorChain() {
        ErrorProcessor errorProcessor = new ErrorProcessor();
        return new SuccessProcessor(errorProcessor);
    }

}
