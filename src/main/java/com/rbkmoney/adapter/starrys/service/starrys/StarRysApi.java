package com.rbkmoney.adapter.starrys.service.starrys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.converter.ip.ConverterIp;
import com.rbkmoney.adapter.starrys.service.starrys.constant.Operations;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.ComplexRequest;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.RequestWrapper;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class StarRysApi {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final ConverterIp converterIp;

    public ResponseEntity<FullResponse> complex(RequestWrapper<ComplexRequest> requestWrapper) {
        return send(requestWrapper, Operations.COMPLEX.getName());
    }

    private ResponseEntity<FullResponse> send(RequestWrapper<ComplexRequest> requestWrapper, String operation) {
        String body;
        try {
            body = objectMapper.writeValueAsString(requestWrapper.getRequest());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String prepareUrl = prepareUrl(operation, requestWrapper.getUrl());
        log.info("{}, {} with request: {}", operation, prepareUrl, body);
        HttpEntity httpEntity = new HttpEntity(body, getHttpHeaders());
        ResponseEntity<FullResponse> responseEntity = restTemplate.exchange(
                prepareUrl, HttpMethod.POST, httpEntity, FullResponse.class
        );
        log.info("{} with response: {}", operation, responseEntity);
        return responseEntity;
    }

    private String prepareUrl(String operation, String url) {
        return converterIp.replaceIpv4ToIpv6(url + operation);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return httpHeaders;
    }

}
