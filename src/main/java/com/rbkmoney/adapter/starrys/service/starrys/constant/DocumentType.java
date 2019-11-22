package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Тип чека для добавляемой товарной позиции.
 * В одном чеке должны быть товарные позиции одного типа
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DocumentType {

    /**
     * Приход (доход)
     */
    DEBIT(0),

    /**
     * Расход
     */
    CREDIT(1),

    /**
     * Возврат прихода (дохода)
     */
    REFUND_DEBIT(2),

    /**
     * Возврат расхода
     */
    REFUND_CREDIT(3);

    private final int value;

}
