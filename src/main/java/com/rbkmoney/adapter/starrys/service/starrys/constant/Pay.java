package com.rbkmoney.adapter.starrys.service.starrys.constant;

/**
 * Таблица 8. Типы оплат в сменном отчёте
 */
public class Pay {

    /**
     * Наличными
     */
    public static final int CASH = 1;

    /**
     * 1-й тип оплаты
     */
    public static final int PAYMENT_TYPE_1 = 2;

    /**
     * 2-й тип оплаты
     */
    public static final int PAYMENT_TYPE_2 = 3;

    /**
     * 3-й тип оплаты
     */
    public static final int PAYMENT_TYPE_3 = 4;

    /**
     * Предоплатой (зачётом аванса)
     */
    public static final int ADVANCE_PAYMENT = 5;

    /**
     * Постоплатой (в кредит)
     */
    public static final int POSTPAY_ON_CREDIT_ = 6;

    /**
     * Встречным предоставлением
     */
    public static final int COUNTER_PROVISION = 7;

}
