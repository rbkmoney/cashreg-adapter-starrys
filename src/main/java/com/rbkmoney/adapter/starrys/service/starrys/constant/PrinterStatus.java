package com.rbkmoney.adapter.starrys.service.starrys.constant;

/**
 * Таблица 5. Биты статуса принтера
 */
public class PrinterStatus {

    /**
     * Принтер в оффлайне
     */
    public static final int PRINTER_IS_OFFLINE = 0;

    /**
     * Закончилась бумага
     */
    public static final int PAPER_HAS_RUN_OUT = 1;

    /**
     * Бумага скоро закончится (этот бит может устанавливаться, в зависимости от модели принтера,
     * при отсутствии датчика скорого окончания бумаги)
     */
    public static final int PAPER_WILL_RUN_OUT_SOON = 2;

    /**
     * Открыта крышка принтера
     */
    public static final int PRINTER_COVER_IS_OPEN = 3;

    /**
     * Восстановимая ошибка принтера
     */
    public static final int RECOVERABLE_PRINTER_ERROR = 4;

    /**
     * Невосстановимая ошибка принтера
     */
    public static final int UNRECOVERABLE_PRINTER_ERROR = 5;

    /**
     * Принтер прислал неправильный ответ
     */
    public static final int PRINTER_SENT_WRONG_ANSWER = 6;

}
