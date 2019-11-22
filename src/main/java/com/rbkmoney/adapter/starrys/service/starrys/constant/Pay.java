package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Таблица 8. Типы оплат в сменном отчёте
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Pay {

    /**
     * Наличными
     */
    CASH(1),

    /**
     * 1-й тип оплаты
     */
    PAYMENT_TYPE_1(2),

    /**
     * 2-й тип оплаты
     */
    PAYMENT_TYPE_2(3),

    /**
     * 3-й тип оплаты
     */
    PAYMENT_TYPE_3(4),

    /**
     * Предоплатой (зачётом аванса)
     */
    ADVANCE_PAYMENT(5),

    /**
     * Постоплатой (в кредит)
     */
    POST_PAY_ON_CREDIT(6),

    /**
     * Встречным предоставлением
     */
    COUNTER_PROVISION(7);

    private final int value;

}
