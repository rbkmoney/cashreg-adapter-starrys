package com.rbkmoney.adapter.starrys.configuration.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.starrys.configuration.properties.StarrysProperties;
import com.rbkmoney.adapter.starrys.service.starrys.StarRysApi;
import com.rbkmoney.adapter.starrys.service.starrys.StarRysClient;
import com.rbkmoney.adapter.starrys.utils.ConverterIp;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(StarrysProperties.class)
public class StarrysClientconfiguration {

    @Bean
    //@RequestScope
    StarRysClient businessRuClient(
            ObjectMapper objectMapper,
            RestTemplate restTemplate,
            StarrysProperties starrysProperties
    ) {
        StarRysApi businessRuApi = new StarRysApi(restTemplate, objectMapper, new ConverterIp(), starrysProperties);
        return new StarRysClient(businessRuApi, starrysProperties);
    }


}
