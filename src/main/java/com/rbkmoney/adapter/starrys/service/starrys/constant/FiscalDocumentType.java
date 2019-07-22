package com.rbkmoney.adapter.starrys.service.starrys.constant;

/**
 * Таблица 2. Тип фискального документа
 */
public class FiscalDocumentType {

    /**
     * Отчёт о регистрации
     */
    public static final int REGISTRATION_REPORT = 1;

    /**
     * Отчёт об открытии смены
     */
    public static final int REPORT_ON_OPENING_OF_SHIFT = 2;

    /**
     * Кассовый чек
     */
    public static final int CASH_RECEIPT = 3;

    /**
     * БСО
     */
    public static final int BSO = 4;

    /**
     * Отчёт о закрытии смены
     */
    public static final int REPORT_ON_CLOSING_OF_SHIFT = 5;

    /**
     * Отчёт о закрытии фискального накопителя
     */
    public static final int REPORT_ON_LOSURE_OF_FISCAL_STORAGE = 6;

    /**
     * Отчёт об изменении параметров регистрации
     */
    public static final int REPORT_ON_CHANGING_REGISTRATION_PARAMETERS = 11;

    /**
     * Отчёт о текущем состоянии расчётов
     */
    public static final int REPORT_ON_CURRENT_STATE_OF_SETTLEMENTS = 21;

    /**
     * Кассовый чек коррекции
     */
    public static final int CASH_CORRECTION_CHECK = 31;

    /**
     * БСО коррекции
     */
    public static final int BSS_CORRECTION = 41;

}
