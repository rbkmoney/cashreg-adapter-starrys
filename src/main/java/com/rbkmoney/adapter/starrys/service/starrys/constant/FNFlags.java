package com.rbkmoney.adapter.starrys.service.starrys.constant;

/**
 * Таблица 7. Флаги состояния ФН
 */
public class FNFlags {

    /**
     * Срочная замена КС (до окончания срока действия 3 дня)
     */
    public static final int URGENT_REPLACEMENT_COP = 0;

    /**
     * Исчерпание ресурса КС (до окончания срока действия 30 дней)
     */
    public static final int EXHAUSTION_CC_RESOURCE = 1;

    /**
     * Переполнение памяти ФН (Архив ФН заполнен на 90 %)
     */
    public static final int MEMORY_OVERFLOW_FN = 2;

    /**
     * Превышено время ожидания ответа ОФД
     */
    public static final int CRF_WAITING_TIME_EXCEEDED = 3;

    /**
     * Критическая ошибка ФН
     */
    public static final int CRITICAL_ERROR_FN = 7;

}
