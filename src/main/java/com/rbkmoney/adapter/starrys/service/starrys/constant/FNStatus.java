package com.rbkmoney.adapter.starrys.service.starrys.constant;

/**
 * Таблица 6. Таблица фаз жизни ФН
 */
public class FNStatus {

    /**
     * Настройка
     */
    public static final int SETTING = 0;

    /**
     * Готовность к фискализации
     */
    public static final int READINESS_FOR_FISCALIZATION = 1;

    /**
     * Фискальный режим
     */
    public static final int FISCAL_MODE = 3;

    /**
     * Пост-фискальный режим, идёт передача фискальных докумен- тов в ОФД
     */
    public static final int POST_FISCAL_REGIME = 7;

    /**
     * Чтение данных из архива ФН
     */
    public static final int READING_DATA_FROM_FN_ARCHIVE = 15;

}
