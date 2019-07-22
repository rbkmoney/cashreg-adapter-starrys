package com.rbkmoney.adapter.starrys.service.starrys.constant;

/**
 * Тип чека для добавляемой товарной позиции.
 * В одном чеке должны быть товарные позиции одного типа
 */
public class DocumentType {

    /**
     * Приход (доход)
     */
    public static final int DEBIT = 0;

    /**
     * Расход
     */
    public static final int CREDIT = 1;

    /**
     * Возврат прихода (дохода)
     */
    public static final int REFUND_DEBIT = 2;

    /**
     * Возврат расхода
     */
    public static final int REFUND_CREDIT = 3;

}
