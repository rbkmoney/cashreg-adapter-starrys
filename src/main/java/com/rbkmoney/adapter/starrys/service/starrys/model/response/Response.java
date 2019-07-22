package com.rbkmoney.adapter.starrys.service.starrys.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.DocumentType;
import com.rbkmoney.adapter.starrys.service.starrys.constant.NonCashType;
import com.rbkmoney.adapter.starrys.service.starrys.constant.PayAttribute;
import com.rbkmoney.adapter.starrys.service.starrys.constant.TaxId;
import com.rbkmoney.adapter.starrys.service.starrys.model.DateTime;
import com.rbkmoney.adapter.starrys.service.starrys.model.FiscalDocument;
import com.rbkmoney.cashreg.proto.provider.TaxMode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    @JsonProperty("Date")
    private DateTime dateTime;

    /**
     * Уникальный идентификатор запроса
     * e.g. "42"
     */
    @JsonProperty("RequestId")
    private String requestId;

    /**
     * Идентификатор клиента
     * e.g. ""
     */
    @JsonProperty("ClientId")
    private String clientId;

    /**
     * Пароль команды
     * e.g. 30
     */
    @JsonProperty("Password")
    private BigInteger password;

    /**
     * Номер ошибки
     * e.g. 0
     */
    @JsonProperty("Error")
    private Integer error;

    /**
     * Список ошибок
     * e.g. ["ERR_NO_ERROR"]
     */
    @JsonProperty("ErrorMessages")
    private List<String> errorMessages;

    /**
     * Номер смены
     * e.g. 56
     */
    @JsonProperty("TurnNumber")
    private Integer turnNumber;

    /**
     * Описание
     */
    @JsonProperty("Description")
    private String description;

    /**
     * Тип чека
     * {@link DocumentType}
     */
    @JsonProperty("DocumentType")
    private Integer documentType;

    /**
     * Номер фискального документа
     * e.g. 1322
     */
    @JsonProperty("FiscalDocNumber")
    private Integer fiscalDocNumber;

    /**
     * (Quantity): Количество
     * e.g. 1000
     */
    @JsonProperty("Qty")
    private Integer qty;

    /**
     * (Money): Цена
     * e.g. 1000
     */
    @JsonProperty("Price")
    private Integer price;

    /**
     * Признак способа расчёта
     *
     * @see PayAttribute
     */
    @JsonProperty("PayAttribute")
    private Integer payAttribute;

    /**
     * Код налога
     * {@link TaxId}
     */
    @JsonProperty("TaxId")
    private Integer taxId;

    @JsonProperty("Value")
    private String value;

    /**
     * Сумма оплаты наличными
     */
    @JsonProperty("Cash")
    private BigInteger cash;

    /**
     * Итог сдачи
     */
    @JsonProperty("Change")
    private Integer change;

    /**
     * Фискальный документ из архива ФН
     * <p>
     * e.g.
     * <pre>
     * <code> {
     *      "TagID": 2,
     *      "TagType": "stlv",
     *      "Value": [
     *          {
     *              "TagID": 1041,
     *              "TagType": "string",
     *              "Value": "9999078900005731"
     *          },
     *      ]
     * } <code>
     * </pre>
     * <p>
     * {@link FiscalDocument}
     */
    @JsonProperty("FiscalDocument")
    private FiscalDocument fiscalDocument;

    /**
     * Фискальная подпись
     */
    @JsonProperty("FiscalSign")
    private BigInteger fiscalSign;

    /**
     * Сумма итогов документов за смену
     */
    @JsonProperty("GrandTotal")
    private Integer grandTotal;

    /**
     * @see NonCashType
     */
    @JsonProperty("NonCash")
    private List<Integer> nonCash;

    @JsonProperty("PaymentAgentModes")
    private Integer paymentAgentModes;

    @JsonProperty("Place")
    private String place;

    @JsonProperty("QR")
    private String qr;

    /**
     * Режим налогооблажения
     *
     * @see TaxMode
     */
    @JsonProperty("TaxMode")
    private Integer taxMode;

    @JsonProperty("Terminal")
    private String terminal;

    @JsonProperty("Text")
    private String text;

}

