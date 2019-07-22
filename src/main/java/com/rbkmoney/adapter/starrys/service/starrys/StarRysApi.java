package com.rbkmoney.adapter.starrys.service.starrys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.starrys.configuration.properties.StarrysProperties;
import com.rbkmoney.adapter.starrys.service.starrys.constant.Operations;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.ComplexRequest;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.IRequest;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import com.rbkmoney.adapter.starrys.utils.ConverterIp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Setter
@Getter
@RequiredArgsConstructor
public class StarRysApi {

    private String url = "https://fce.starrys.ru:4443/fr/api/v2/";
    private int password;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final ConverterIp converterIp;
    private final StarrysProperties starrysProperties;

    public ResponseEntity<FullResponse> complex(ComplexRequest request) throws JsonProcessingException {
        return send(request, Operations.COMPLEX);
    }

    private ResponseEntity send(IRequest request, String operation) throws JsonProcessingException {
        String body = objectMapper.writeValueAsString(request);
        String prepareUrl = prepareUrl(operation);
        log.info("{}, {} with request: {}", operation, prepareUrl, body);
        HttpEntity httpEntity = new HttpEntity(body, getHttpHeaders());
        ResponseEntity<FullResponse> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, httpEntity, FullResponse.class
        );
        log.info("{} with response: {}", operation, responseEntity);
        return responseEntity;
    }

    private String prepareUrl(String operation) {
        return converterIp.replaceIpv4ToIpv6(getUrl() + operation);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return httpHeaders;
    }

}
