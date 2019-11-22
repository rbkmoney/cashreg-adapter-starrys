package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ReceiptType {

    /**
     * Приход
     */
    COMING(1),

    /**
     * Расход
     */
    CONSUMPTION(3),

    /**
     * Возврат прихода
     */
    RETURN_OF_PARISH(2),

    /**
     * Возврат расхода
     */
    RETURN_OF_CONSUMPTION(4);

    private final int value;

}
