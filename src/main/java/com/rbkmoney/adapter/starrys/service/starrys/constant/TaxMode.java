package com.rbkmoney.adapter.starrys.service.starrys.constant;

public class TaxMode {

    /**
     * Общая
     */
    public static final int TOTAL = 1;

    /**
     * Упрощённая доход
     */
    public static final int SIMPLIFIED_INCOME = 2;

    /**
     * Упрощённая доход минус расход
     */
    public static final int SIMPLIFIED_REVENUE_MINUS_CONSUMPTION = 4;

    /**
     * Единый налог на вменённый доход
     */
    public static final int A_SINGLE_TAX_ON_IMPUTED_INCOME = 8;

    /**
     * Единый сельскохозяйственный налог
     */
    public static final int UNIFIED_AGRICULTURAL_TAX = 16;

    /**
     * Патентная система налогообложения
     */
    public static final int PATENT_SYSTEM_OF_TAXATION = 32;

}
