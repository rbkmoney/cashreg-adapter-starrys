package com.rbkmoney.adapter.starrys.service.starrys.constant;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Таблица 26 Расширенные сообщения об ошибках
 * <p>
 * Enumeration of json API  error codes.
 */
@Getter
@RequiredArgsConstructor
public enum JsonApiErrors {

    ERROR_NO_MORE(0, "Ошибок не обнаружено"),
    ERROR_CREATING_ARCHIVE_FILE(1, "Ошибка создания файла с архивом"),
    ERROR_CREATING_FILE_IN_ARCHIVE(2, "Ошибка создания файла в архиве"),
    ERROR_OPENING_FILE(3, "Ошибка открытия файла"),
    COPY_ERROR(4, "Ошибка копирования"),
    ERROR_CLOSING_ARCHIVE_FILE(5, "Ошибка закрытия файла с архивом"),
    ERROR_SENDING_MAIL(6, "Ошибка отправки почты"),
    ERROR_READING_FILE(7, "Ошибка чтения файла"),
    WRONG_TYPE_OF_DOCUMENT(8, "Неправильный тип документа"),
    READ_ERROR_FROM_TABLE(9, "Ошибка чтения из таблицы"),
    ERROR_WRITING_TO_THE_TABLE(10, "Ошибка записи в таблицу"),
    ERROR_CREATING_THE_DATABASE(11, "Ошибка создания БД"),
    ERROR_OBTAINING_PUBLIC_SWITCH_INFORMATION(12, "Ошибка получения информации об открытой смене"),
    ERROR_GETTING_INFORMATION_ABOUT_OPEN_DOCUMENT(13, "Ошибка получения информации об открытом документе"),
    SHIFT_ID_IN_THE_DOCUMENT_DOES_NOT_MATCH_THE_ID_OF_THE_SHIFT(14, "Идентификатор смены в документе не соответствует идентификатору смены"),
    ERROR_WITH_INSERT_IN_THE_TABLE(15, "Ошибка при INSERT в таблицу"),
    ERROR_WHILE_SELECT_FROM_TABLE(16, "Ошибка при SELECT из таблицы"),
    ERROR_WHILE_RETRIEVING_DATA_FROM_THE_TABLE(17, "Ошибка при получении данных из таблицы"),
    ERROR_WHILE_UPDATE_IN_THE_TABLE(18, "Ошибка при UPDATE в таблице"),
    ERROR_WITH_INSERT_OR_UPDATE_TABLES(19, "Ошибка при INSERT OR UPDATE таблицы"),
    ERROR_GETTING_CHANGED_ROWS_FROM_TABLE(20, "Ошибка получения изменённых строк из таблицы"),
    ERROR_API_FN_FUNCTION(21, "Ошибка API ФН, функция"),
    ERROR_READING_FROM_RTC(22, "Ошибка чтения времени из RTC"),
    CLOCK_SETTING_ERROR_IN_RTC(23, "Ошибка установки часов в RTC"),
    FAILED_TO_SAVE_THE_FACTORY_FN_NUMBER_IN_THE_TABLE(24, "Ошибка сохранения заводского номера ФН в таблице"),
    ERROR_READING_THE_NUMBER_OF_THE_SAVED_DOCUMENT(25, "Ошибка чтения номера сохранённого документа"),
    ERROR_RETRIEVING_DOCUMENT(26, "Ошибка восстановления документа"),
    ERROR_SAVING_SAVED_DOCUMENT(27, "Ошибка печати сохранённого документа"),
    THE_SERIAL_NUMBER_OF_THE_FN_WITH_WHICH_THE_REGISTRATION_WAS_MADE_DOES_NOT_COINCIDE(28, "Серийный номер ФН, с которым осуществлялась регистрация не совпадает с тем, который установлен в устройстве"),
    ERROR_WHILE_PRINTING(29, "Ошибка во время печати"),
    ERROR_CREATING_THE_FLAG_FILE(30, "Ошибка создания флаг-файла"),
    ERROR_WHILE_READING_ENCASHMENT_PARAMETERS(31, "Ошибка чтения параметров инкассации"),
    ERROR_SETTING_DHCP_MODE(32, "Ошибка при установке режима DHCP"),
    ERROR_WHILE_SETTING_NETWORK_PARAMETERS(33, "Ошибка при установке сетевых параметров"),
    READ_ERROR_OF_BYTE_PARAMETER(34, "Ошибка чтения байтового параметра"),
    ERROR_READING_FIVE_BYTE_PARAMETER(35, "Ошибка чтения пятибайтового параметра"),
    ERROR_CONVERTING_STRING_TO_NUMBER(36, "Ошибка преобразования строки  в число"),
    FAILED_TO_GET_REGISTER_CONTENTS(37, "Ошибка получения содержимого регистра"),
    ERROR_READING_BLOCK_PARAMETER(39, "Ошибка чтения блочного параметра"),
    ERROR_READING_2_BYTE_PARAMETER(40, "Ошибка чтения 2-х байтового параметра"),
    INVALID_MD_CODE_PARAMETER(41, "Неправильный параметр mD-кода"),
    ERROR_READING_4_BYTE_PARAMETER(42, "Ошибка чтения 4-х байтового параметра"),
    ERROR_READING_LINE(43, "Ошибка чтения строки"),
    ERROR_READING_DATE_OR_TIME(44, "Ошибка чтения даты или времени"),
    ERROR_READING_MONEY_OR_QUANTITY(45, "Ошибка чтения денежной или количественной величины"),
    TRANSPORT_CAN_NOT_BE_PRESENT_IN_THE_CONFIGURATION_MORE_THAN_ONCE(46, "Транспорт  не может присутствовать в конфигурации более одного раза"),
    NO_ACTIVE_TRANSPORTS(47, "Нет активных транспортов протокола"),
    INVALID_PAYMENT_OPTION(48, "Неправильный параметр платежа"),
    INVALID_TAXATION_REGIME(49, "Неверный режим налогообложения (передано больше одного вида или не соответствуют заданным при регистрации)"),
    INVALID_ADJUSTMENT_PARAMETER(50, "Неверный параметр корректировки"),
    WRONG_FIELD_NUMBER_OF_THE_REGISTRATION_PARAMETER_TABLE(51, "Неверный номер поля таблицы регистрационных параметров"),
    A_LINE_WITH_FIELDS_CONTAINS_THE_WRONG_NUMBER_OF_FIELDS(52, "Строка с полями содержит неверное количество полей, должно быть , в наличии"),
    ERROR_CONVERTING_A_STRING(53, "Ошибка при конвертации строки из Windows-1251 в UTF-8"),
    WRONG_INDICATION_OF_THE_METHOD_OF_CALCULATION(54, "Неправильный признак способа расчёта"),
    INVALID_TAX_CODE(55, "Неправильный код налога"),
    THE_TYPE_OF_TAG_THAT_IS_NOT_PRESENT_IN_THE_BINARY_PROTOCOL(56, "Непредставимый в бинарном протоколе тип тега"),
    TAG_ID_NOT_FOUND_OR_UNKNOWN(57, "Идентификатор тега не найден или неизвестен"),
    REGISTRATION_PARAMETER_VERIFICATION_ERROR(58, "Ошибка проверки регистрационного параметра"),
    INVALID_HASH_LENGTH(59, "Неверная длина хэша"),
    INVALID_FONT_NUMBER(60, "Неверный номер шрифта"),
    WRONG_MONEY_REGISTER(61, "Неверный денежный регистр"),
    WRONG_QUANTITATIVE_REGISTER(62, "Неверный количественный регистр"),
    WRONG_NUMBER_OF_ADD_DOCUMENT_PARAMETER(63, "Неверный номер доп. параметра документа"),
    WRONG_NUMBER_OF_ADD_ITEM_PARAMETER(64, "Неверный номер доп. параметра товарной позиции"),
    THE_TYPE_OF_THE_PARAMETER_DOES_NOT_MATCH_THE_TYPE_OF_THE_TABLE_FIELD(65, "Тип параметра не соответствует типу поля таблицы"),
    ERROR_CONVERTING_TO_CP866_ENCODING(66, "Ошибка при преобразовании в кодировку CP866"),
    THE_COMMAND_CAN_NOT_BE_EXECUTED_IN_THE_CURRENT_PHASE_OF_LIFE_FN(67, "Команда не может быть выполнена в текущей фазе жизни ФН"),
    UNKNOWN_PASSWORD(68, "Неизвестный пароль"),
    THE_PRINTER_IS_OFFLINE(69, "Принтер в оффлайне");

    private final int code;
    private final String message;

    /**
     * Return the enum constant of this type with the specified numeric value.
     *
     * @param errorCode the numeric value of the enum to be returned
     * @return the enum constant with the specified numeric value
     * @throws IllegalArgumentException if this enum has no constant for the specified numeric value
     */
    public static JsonApiErrors valueOf(int errorCode) {
        for (JsonApiErrors errors : values()) {
            if (errors.code == errorCode) {
                return errors;
            }
        }
        throw new IllegalArgumentException("No matching for [" + errorCode + "]");
    }

}
