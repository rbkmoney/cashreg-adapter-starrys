package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PayAttribute {
    FOR_INDIVIDUAL_ENTREPRENEURS(0),
    FULL_PAYMENT_BEFORE(1),
    PART_PAYMENT_BEFORE(2),
    PREPAID_EXPENSE(3),
    FULL_PAYMENT(4),
    PART_PAYMENT(5),
    WITHOUT_PAYMENT(5),
    CREDIT_PAYMENT(7);

    private final int value;

}
