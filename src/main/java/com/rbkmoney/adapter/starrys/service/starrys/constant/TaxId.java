package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Таблица 33. Налоги
 * Value Added Tax (VAT) – налог на добавленную стоимость (НДС)
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TaxId {

    public static final int VAT_18 = 1;
    public static final int VAT_20 = 1;
    public static final int VAT_10 = 2;
    public static final int VAT_0 = 3;
    public static final int NO_VAT = 4;
    public static final int VAT_18_118 = 5;
    public static final int VAT_20_120 = 5;
    public static final int VAT_10_110 = 6;

}

