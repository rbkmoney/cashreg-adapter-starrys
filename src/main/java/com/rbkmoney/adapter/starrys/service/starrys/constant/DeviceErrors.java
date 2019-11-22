package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Таблица 25: Коды ошибок устройства
 */
@Getter
@RequiredArgsConstructor
public enum DeviceErrors {

    ERROR_NO_MORE(0, "Ошибок не обнаружено"),
    UNKNOWN_FN_COMMAND(1, "Неизвестная команда ФН"),
    FN_STATE_DOES_NOT_CORRESPOND_TO_THE_SENT_COMMAND(2, "Состояние ФН не соответствует присланной команде"),
    FN_ERROR(3, "Ошибка ФН"),
    FH_COMMAND_CHECKSUM_ERROR(4, "Ошибка контрольной суммы команды ФН"),
    THE_SERVICE_LIFE_OF_THE_FN(5, "Закончен срок эксплуатации ФН"),
    ARCHIVE_FN_IS_OVERCROWDED(6, "Архив ФН переполнен"),
    DATE_AND_TIME_DO_NOT_CORRESPOND_TO_THE_LOGIC_OF_THE_FN(7, "Дата и время не соответствую логике работы ФН"),
    THE_REQUESTED_DATA_ARE_NOT_AVAILABLE_IN_THE_FN_ARCHIVE(8, "Запрошенные данные отсутствуют в архиве ФН"),
    INCORRECT_PARAMETERS_OF_THE_FN_COMMAND(9, "Некорректные параметры команды ФН"),
    THE_SIZE_OF_THE_TRANSMITTED_DATA_EXCEEDED_THE_PERMISSIBLE(16, "Размер передаваемых данных превысил допустимый"),
    NO_TRANSPORT_CONNECTION_WITH_CRF(17, "Нет транспортного соединения с ОФД"),
    THE_RESOURCE_OF_THE_CRYPTOGRAPHIC_COPROCESSOR_FN_HAS_BEEN_EXHAUSTED(18, "Исчерпан ресурс криптографического сопроцессора ФН. Требуется закрыть фискальный режим"),
    THE_RESOURCE_FOR_STORING_DOCUMENTS_FOR_THE_CRF_HAS_BEEN_EXHAUSTED(20, "Ресурс для хранения документов для ОФД исчерпан"),
    EXPECTED_WAITING_TIME_FOR_STORING_DATA_IN_FN(21, "Исчерпан ресурс ожидания хранения данных в ФН"),
    DURATION_OF_SHIFT_MORE_THAN_24_HOURS(22, "Продолжительность смены долее 24 часов"),
    INCORRECT_TIME_DIFFERENCE_BETWEEN_2_OPERATIONS(23, "Неверная разница во времени между 2 операциями (более 5 минут)"),
    A_MESSAGE_FROM_THE_CRF_CAN_NOT_BE_ACCEPTED(32, "Сообщение от ОФД не может быть принято"),
    NOTHING_IMPORTANT_HAS_CHANGED(40, "Ничего важного не изменилось, перерегистрация не нужна"),
    TIN_AND_REGISTRATION_NUMBER_MUST_NOT_BE_CHANGED(41, "ИНН и регистрационный номер не должны меняться"),
    THE_COMMAND_PARAMETER_CONTAINS_INVALID_DATA(51, "Параметр команды содержит неверные данные"),
    MISSING_DATA_FOR_THE_TEAM(52, "Отсутствуют данные для команды"),
    COMMAND_NOT_IMPLEMENTED(55, "Команда не реализована"),
    INTERNAL_DEVICE_ERROR(57, "Внутренняя ошибка устройство"),
    CHANGE_IS_OPEN(60, " Смена открыта"),
    CHANGE_NOT_OPEN(61, "Смена не открыта"),
    THE_SUM_OF_ALL_PAYMENTS_IS_LESS_THAN_THE_TOTAL_OF_THE_CHECK(69, "Сумма всех оплат меньше итога чека"),
    NOT_ENOUGH_CASH_ON_HAND(70, "Не хватает наличности в кассе"),
    INVALID_DOCUMENT_TYPE_FOR_THIS_COMMAND(73, "Неверный тип документа для данной команды"),
    THE_CHECK_IS_OPEN(74, "Чек открыт"),
    THE_AMOUNT_OF_ELECTRONIC_FORMS_OF_PAYMENT_IS_GREATER_THAN_THE_TOTAL_OF_THE_CHECK(77, "Сумма электронных видов оплаты больше итога чека"),
    WRONG_PASSWORD_FOR_THIS_COMMAND(79, "Неверный пароль для данной команды"),
    THE_DATA_IS_PRINTED(80, "Данные печатаются"),
    CHECK_CLOSED(85, "Чек закрыт"),
    THE_DISCOUNT_IS_MORE_THAN_THE_TOTAL_ON_THE_LINE(90, "Скидка больше итога по строке"),
    INVALID_COMMAND(94, "Неверная команда"),
    REASONABLY_MORE_THAN_THE_TOTAL_OF_THE_CHECK(95, "Сторно больше итога чека"),
    THERE_IS_NOT_ENOUGH_TURNOVER_ON_THE_TAX(109, "Не хватает оборота по налогу"),
    THE_COMMAND_IS_NOT_ALLOWED_IN_THIS_SUBMODE(114, "Команда не допустима в этом подрежиме"),
    THE_COMMAND_IS_NOT_VALID_IN_THIS_DEVICE_STATE(115, "Команда не допустима в этом состоянии устройства"),
    WRONG_DATE(124, "Ошибочная дата"),
    BADLY_FORMED_DATE(125, "Неверно сформированная дата"),
    ZERO_CHECK_TOTAL(142, "Нулевой итог чека"),
    WAITING_FOR_DATE_CONFIRMATION(192, "Ожидание подтверждения даты"),
    CHANGE_NUMBER_IN_FN_DOES_NOT_CORRESPOND_TO_THE_SHIFT_NUMBER_IN_THE_DEVICE(196, "Номер смены в ФН не соответствует номеру смены в устройстве"),
    PRINTER_TIMEOUT(200, "Тайм-аут принтера"),
    INVALID_DATE_TIME(207, "Неправильная дата/время"),
    THE_DOCUMENT_DOES_NOT_CONTAIN_COMMODITY_ITEMS(208, "Документ не содержит товарных позиций"),
    THE_GROUP_NUMBER_THAT_CAME_FROM_THE_FCE_SERVER_DOES_NOT_MATCH_THE_DEVICE_GROUP(238, "Номер группы, пришедший от сервера FCE не соответствует группе устройства"),
    THE_LEASE_TERM_OF_THE_DEVICE_HAS_EXPIRED(239, "Истёк срок аренды устройства"),
    ERROR_WHILE_EXECUTING_THE_COMPLEX_COMMAND(240, "Ошибка при выполнении комплексной команды (см. п. 2.4)"),
    UNKNOWN_COMMAND_IN_THE_PACKAGE(241, "Неизвестная команда в пакете"),
    AN_EMPTY_QUERY(242, "Пустой запрос"),
    MISSING_REQUESTID_REQUEST_ID(243, "Отсутствует идентификатор запроса RequestId"),
    ERROR_CONVERTING_TO_JSON(244, "Ошибка при конвертации в JSON"),
    MISSING_REQUESTID_BATCH_REQUEST_IDENTIFIER(245, "Отсутствует идентификатор пакетного запроса RequestId"),
    ERROR_CONVERTING_FROM_JSON(246, "Ошибка при конвертации из JSON"),
    THE_NON_EXISTENT_SHIFT(247, "Несуществующая смена"),
    REGISTRATION_PARAMETERS_HAVE_BEEN_CHANGED(248, "Изменены регистрационные параметры"),
    TRANSPORT_LAYER_ERROR_WHEN_RETRIEVING_DATA_FROM_THE_FN_ARCHIVE(249, "Ошибка транспортного уровня при получении данных из архива ФН"),
    THE_MAIN_BOARD_OF_THE_DEVICE_DOES_NOT_RESPOND(250, "Основная плата устройства не отвечает"),
    INVALID_FILE_CHECKSUM(252, "Неверная контрольная сумма файла"),
    OTHER_PRINTER_ERRORS(253, "Прочие ошибки принтера"),
    OFFLINE_PRINTER(254, "Принтер в оффлайне"),
    FATAL_DEVICE_ERROR(255, "Фатальная ошибка устройства");

    private final int code;
    private final String message;


    public static DeviceErrors valueOf(int errorCode) {
        for (DeviceErrors errors : values()) {
            if (errors.code == errorCode) {
                return errors;
            }
        }
        throw new IllegalArgumentException("No matching for [" + errorCode + "]");
    }

}
