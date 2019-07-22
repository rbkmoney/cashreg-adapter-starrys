package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Таблица 23. Коды состояния устройства
 */
@Getter
@Setter
@ToString
public class DeviceStatus {

    /**
     * 0x00
     * Состояние устройства после старта
     * (фактически можно рассматривать это состояние как 0x04 «Смена закрыта»)
     */
    public static final int AFTER_START = 0;

    /**
     * 0x02
     * Смена открыта
     */
    public static final int OPEN_TURN = 2;

    /**
     * 0x03
     * Смена открыта более 24 часов
     */
    public static final int OPEN_GREAT_24 = 3;

    /**
     * 0x04
     * Смена закрыта
     */
    public static final int CLOSE_TURN = 4;

    /**
     * 0x06
     * Ожидает подтверждения даты
     */
    public static final int WAITING_DATE_APROUVE = 6;

    /**
     * 0x08
     * Открыт документ прихода
     */
    public static final int DOCUMENT_OPEN_DEBIT = 8;

    /**
     * 0x18
     * Открыт документ расхода
     */
    public static final int DOCUMENT_OPEN_CREDIT = 24;

    /**
     * 0x28
     * Открыт документ возврата прихода
     */
    public static final int DOCUMENT_OPEN_REFUND_DEBIT = 40;

    /**
     * 0x38
     * Открыт документ возврата расхода
     */
    public static final int DOCUMENT_OPEN_REFUND_CREDIT = 56;

    /**
     * 0xFF
     * Фатальная ошибка устройства
     */
    public static final int FATAL_ERROR = 255;

}
