package com.rbkmoney.adapter.starrys.service.starrys.constant;

/**
 * Операции с фискальным аппаратом
 */
public class Operations {

    /**
     * Пустая операция
     */
    public static final String NO_OPERATION = "NoOperation";

    /**
     * Идентификация устройства в стойке
     */
    public static final String IDENT_DEVICE = "IdentDevice";

    /**
     * Запуск процесса проверки целостности системы
     */
    public static final String CALC_SHA512 = "CalcSHA512";

    /**
     * Получение контрольной суммы ПО устройства
     */
    public static final String GET_FILE_HASH = "GetFileHash";

    /**
     * Загрузка файла с обновлением ПО
     */
    public static final String SAVE_FILE = "SaveFile";

    /**
     * Подтверждение переданного файла
     */
    public static final String CHECK_FILE_SHA512 = "CheckFileSHA512";

    /**
     * Отправка протокола работы устройства по электронной почте
     */
    public static final String SEND_MAIL = "SendMail";

    /**
     * Печать протокола работы устройства
     */
    public static final String PRINT_LOG = "PrintLog";

    /**
     * Установка параметров сети из таблиц
     */
    public static final String SET_NETWORK_PARAMETERS = "SetNetworkParameters";

    /**
     * Быстрый перезапуск устройства
     */
    public static final String RESTART = "Restart";

    /**
     * Полный перезапуск устройства
     */
    public static final String REBOOT = "Reboot";

    /**
     * Выключение устройства
     */
    public static final String POWER_OFF = "Poweroff";

    /**
     * Запрос состояния устройства
     */
    public static final String LONGDEVICESTATUS = "LongDeviceStatus";

    /**
     * Печать строки
     */
    public static final String PRINT_STRING = "PrintString";

    /**
     * Получить значение денежного регистра
     */
    public static final String GET_MONEY_REGISTER = "GetMoneyRegister";

    /**
     * Получить значение количественного регистра
     */
    public static final String GET_OPER_REGISTER = "GetOperRegister";

    /**
     * Установка времени на устройстве
     */
    public static final String PREPARE_TIME = "PrepareTime";

    /**
     * Установка даты на устройстве
     */
    public static final String PREPARE_DATE = "PrepareDate";

    /**
     * Подтверждение даты
     */
    public static final String CONFIRM_DATE = "ConfirmDate";

    /**
     * Отрезка документа
     */
    public static final String CUTPAPER = "CutPaper";

    /**
     * Печать пустых строк
     */
    public static final String FEED_PAPER = "FeedPaper";

    /**
     * Закрытие смены
     */
    public static final String CLOSE_TURN = "CloseTurn";

    /**
     * Промежуточный сменный отчёт
     */
    public static final String INTERMEDIATE_TURN_REPORT = "IntermediateTurnReport";

    /**
     * Добавление в чек операции
     */
    public static final String ADD_LINE_TO_DOCUMENT = "AddLineToDocument";

    /**
     * Закрытие чека
     */
    public static final String CLOSE_DOCUMENT = "CloseDocument";

    /**
     * Подытог чека
     */
    public static final String GET_SUBTOTAL = "GetSubtotal";

    /**
     * Повторение печати последнего напечатанного документа
     */
    public static final String PRINT_LAST_SAVED_DOCUMENT = "PrintLastSavedDocument";

    /**
     * Открытие чека
     */
    public static final String OPEN_DOCUMENT = "OpenDocument";

    /**
     * Аннулирование чека
     */
    public static final String CANCEL_DOCUMENT = "CancelDocument";

    /**
     * Добавление дополнительных параметров к чеку
     */
    public static final String ADD_PHONE_OF_TRANSFER_OPERATOR = "AddPhoneOfTransferOperator";

    public static final String ADD_OPERATION_OF_PAYMENT_AGENT = "AddOperationOfPaymentAgent";

    public static final String ADD_PHONE_OF_PAYMENT_AGENT = "AddPhoneOfPaymentAgent";

    public static final String ADD_PHONE_OF_GET_PAYMENT_OPERATOR = "AddPhoneOfGetPaymentOperator";

    public static final String ADD_NAME_OF_TRANSFER_OPERATOR = "AddNameOfTransferOperator";

    public static final String ADD_ADDRESS_OF_TRANSFER_OPERATOR = "AddAddressOfTransferOperator";

    public static final String ADD_INN_OF_TRANSFER_OPERATOR = "AddINNOfTransferOperator";

    public static final String ADD_PHONE_OF_PROVIDER = "AddPhoneOfProvider";

    public static final String ADD_ADDITIONAL_DOCUMENT_REQUISITE = "AddAdditionalDocumentRequisite";

    public static final String ADD_PHONE_OR_EMAIL_OF_CUSTOMER = "AddPhoneOrEmailOfCustomer";

    public static final String ADD_EMAIL_OF_DEVICE_USER = "AddEmailOfDeviceUser";

    /**
     *
     */
    public static final String ADD_USER_REQUISITE = "AddUserRequisite";

    /**
     * Добавление дополнительных параметров к товарной позиции чека
     */
    public static final String ADD_CGN = "AddCGN";

    public static final String ADD_ADDITIONAL_DOCUMENT_LINE_REQUISITE = "AddAdditionalDocumentLineRequisite";

    public static final String ADD_PRE_TEXT = "AddPreText";

    public static final String ADD_POST_TEXT = "AddPostText";


    /**
     * Отчёт о регистрации
     */
    public static final String REGISTRATION_REPORT = "RegistrationReport";

    /**
     * Отчёт о перерегистрации с заменой ФН
     */
    public static final String RE_REGISTRATION_REPORT_WITH_FN_CHANGE = "ReRegistrationReportWithFNChange";

    /**
     * Отчёт о перерегистрации без замены ФН
     */
    public static final String RE_REGISTRATION_REPORT_WITHOUT_FN_CHANGE = "ReRegistrationReportWithoutFNChange";

    /**
     * Получение результатов регистрации
     */
    public static final String GET_REGISTRATION_RESULT = "GetRegistrationResult";

    /**
     * Удаление данных
     */
    public static final String CLEAR_DEVICE_DATA = "ClearDeviceData";

    /**
     * Печать регистрационных параметров
     */
    public static final String PRINT_REGISTRATION_PARAMETERS = "PrintRegistrationParameters";

    /**
     * Отчёт о состоянии расчётов ФН
     */
    public static final String STATE_REPORT = "StateReport";

    /**
     * Получение номера, даты и времени последнего сформированного в ФН фискального документа
     */
    public static final String GET_LAST_FISCAL_DOCUMENT_INFO = "GetLastFiscalDocumentInfo";

    /**
     * Печать последнего сформированного в ФН фискального документа
     */
    public static final String PRINT_LAST_FISCAL_DOCUMENT = "PrintLastFiscalDocument";

    /**
     * Печать фискального документа по номеру
     */
    public static final String PRINT_FISCAL_DOCUMENT_BY_NUMBER = "PrintFiscalDocumentByNumber";

    /**
     * Получения состояния информационного обмена с ОФД
     */
    public static final String GET_FDO_EXCHANGE_STATUS = "GetFDOExchangeStatus";

    /**
     * Получение значения из фискального документа по номеру тега
     */
    public static final String GET_FISCAL_DOCUMENT_BY_NUMBER = "GetFiscalDocumentByNumber";

    /**
     * Получение короткого фискального документа по номеру
     */
    public static final String GET_SHORT_FISCAL_DOCUMENT_BY_NUMBER = "GetShortFiscalDocumentByNumber";

    /**
     * Получение квитанции от ОФД по номеру фискального документа
     */
    public static final String GET_FDO_TICKET = "GetFDOTicket";

    /**
     * Запись поля таблицы
     */
    public static final String SET_TABLE_FIELD = "SetTableField";

    /**
     * Чтение поля таблицы
     */
    public static final String GET_TABLE_FIELD = "GetTableField";

    /**
     * Получение набора полей таблиц
     */
    public static final String GET_TABLE_DATA = "GetTableData";

    /**
     * Отчёт о закрытии фискального режима
     */
    public static final String CLOSE_FISCAL_MODE = "CloseFiscalMode";

    /**
     * Добавление документа коррекции
     */
    public static final String MAKE_CORRECTION_DOCUMENT = "MakeCorrectionDocument";

    /**
     * Печать значений регистров
     */
    public static final String PRINT_REGISTERS = "PrintRegisters";

    /**
     * Печать копий документов
     */
    public static final String PRINT_SAVED_DOCUMENTS = "PrintSavedDocuments";

    /**
     * Открытие смены
     */
    public static final String OPEN_TURN = "OpenTurn";

    /**
     * Комплексная команда создания чека Complex
     */
    public static final String COMPLEX = "Complex";

}
