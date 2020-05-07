package com.rbkmoney.adapter.starrys.configuration;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.converter.CashregAdapterServiceLogDecorator;
import com.rbkmoney.adapter.starrys.handler.StarrysServerHandler;
import com.rbkmoney.damsel.cashreg.adapter.CashregAdapterSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfiguration {

    @Bean
    @Autowired
    public CashregAdapterSrv.Iface serverHandlerLogDecorator(StarrysServerHandler serverHandler) {
        return new CashregAdapterServiceLogDecorator(serverHandler);
    }

}
