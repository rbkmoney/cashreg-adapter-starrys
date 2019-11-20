package com.rbkmoney.adapter.starrys.service.starrys.constant;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum OptionalField {

    DEVICE("device"),
    PAYMENT_TYPE("payment_type");

    private final String field;
}
