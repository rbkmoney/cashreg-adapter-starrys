package com.rbkmoney.adapter.starrys.service.starrys.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.model.DateTime;
import com.rbkmoney.adapter.starrys.service.starrys.model.FiscalDocument;
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

    @JsonProperty("RequestId")
    private String requestId;

    @JsonProperty("ClientId")
    private String clientId;

    @JsonProperty("Password")
    private BigInteger password;

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

    @JsonProperty("Description")
    private String description;

    @JsonProperty("DocumentType")
    private Integer documentType;

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

    @JsonProperty("PayAttribute")
    private Integer payAttribute;

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

    @JsonProperty("FiscalDocument")
    private FiscalDocument fiscalDocument;

    @JsonProperty("FiscalSign")
    private BigInteger fiscalSign;

    @JsonProperty("GrandTotal")
    private Integer grandTotal;

    @JsonProperty("NonCash")
    private List<Integer> nonCash;

    @JsonProperty("PaymentAgentModes")
    private Integer paymentAgentModes;

    @JsonProperty("Place")
    private String place;

    @JsonProperty("QR")
    private String qr;

    @JsonProperty("TaxMode")
    private Integer taxMode;

    @JsonProperty("Terminal")
    private String terminal;

    @JsonProperty("Text")
    private String text;

}

