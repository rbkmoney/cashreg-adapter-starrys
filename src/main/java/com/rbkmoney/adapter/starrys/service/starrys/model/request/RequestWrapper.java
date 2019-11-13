package com.rbkmoney.adapter.starrys.service.starrys.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestWrapper<R> {
    private R request;
    private String url;
    private String group;
    private String company;
    private String companyAddress;
    private String device;
    private String password;
    private String token;
}
