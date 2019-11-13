package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Таблица 4: Ошибки сервера FCE
 */
@Getter
@RequiredArgsConstructor
public enum FCEError {

    ERROR_READING_REQUEST(1, "Ошибка чтения запроса"),
    JSON_RECOGNITION_ERROR(2, "Ошибка распознавания JSON"),
    THE_DEVICE_FIELD_IS_MISSING(3, "Отсутствует поле Device"),
    THERE_IS_NO_DURATION_OR_QUEUELEN_FIELD(4, "Отсутствует поле Duration или QueueLen"),
    NO_SUITABLE_DEVICES(5, "Нет подходящих устройств (согласной выбранной стратегии)"),
    ERROR_SENDING_REQUEST_TO_DEVICE(6, "Ошибка отправки запроса устройству"),
    THE_DEVICE_FIELD_AUTO__IS_VALID_ONLY_IN_BATCH_COMMANDS(7, "Значение поля Device \"auto\" допустимо только в пакетных командах"),
    THE_NAME_OR_DEVICE_ADDRESS_IS_INCORRECT(8, "Неправильно имя (заводской номер) или адрес устройства"),
    WRONG_DEVICE_ADDRESS(9, "Неправильный адрес устройства"),
    WRONG_DEVICE_NAME(10, "Неправильное имя (заводской номер) устройства"),
    DEVICE_ACTFCEErrorIVATION_ERROR(12, "Ошибка активации устройства"),
    DEVICE_ALREADY_EXISTS(13, "Устройство уже существует"),
    DEVICE_IS_NOT_ACTIVATED(14, "Устройство не активировано"),
    INCORRECTLY_GENERATED_DEVICE_PASSWORD(15, "Неправильно сформированный пароль устройства"),
    ERROR_RECOGNIZING_JSON_RESPONSE(16, "Ошибка распознавания JSON ответа"),
    MISSING_REQUESTID_FIELD(17, "Отсутствует поле RequestId"),
    DEVICE_IS_BUSY(18, "Устройство занято"),
    SERVER_CACHE_ERROR(19, "Ошибка кэша сервера"),
    ASYNCHRONOUS_REQUEST_QUEUE_ERROR(20, "Ошибка очереди асинхронных запросов"),
    CALLBACK_FIELD_IS_VALID_ONLY_IN_BATCH_AND_COMPLEX_COMMANDS(21, "Поле Callback допустимо только в командах Batch и Complex"),
    REQUEST_DURING_PROCESSING(24, "Запрос в процессе обработки");

    private final int code;
    private final String message;


    /**
     * Return the enum constant of this type with the specified numeric value.
     *
     * @param errorCode the numeric value of the enum to be returned
     * @return the enum constant with the specified numeric value
     * @throws IllegalArgumentException if this enum has no constant for the specified numeric value
     */
    public static FCEError valueOf(int errorCode) {
        for (FCEError errors : values()) {
            if (errors.code == errorCode) {
                return errors;
            }
        }
        throw new IllegalArgumentException("No matching for [" + errorCode + "]");
    }

}
