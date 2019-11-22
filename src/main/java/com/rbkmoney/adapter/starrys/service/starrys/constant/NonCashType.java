package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Таблица 32: Типы оплат
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum NonCashType {

    /**
     * Наличными
     */
    CASH(1),

    /**
     * Картой
     */
    CARD(2),

    /**
     * Электронным денежным средством
     */
    ECASH(3),

    /**
     * Иным электронным платежным средством
     */
    OTHER(4);

    private final int value;

}
