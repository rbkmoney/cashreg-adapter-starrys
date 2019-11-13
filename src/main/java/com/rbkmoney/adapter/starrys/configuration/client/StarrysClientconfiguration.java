package com.rbkmoney.adapter.starrys.configuration.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.converter.ip.ConverterIp;
import com.rbkmoney.adapter.starrys.service.starrys.StarRysApi;
import com.rbkmoney.adapter.starrys.service.starrys.StarRysClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class StarrysClientconfiguration {

    @Bean
    StarRysClient atolClient(ObjectMapper objectMapper, RestTemplate restTemplate, ConverterIp converterIp) {
        return new StarRysClient(new StarRysApi(restTemplate, objectMapper, converterIp));
    }

}
