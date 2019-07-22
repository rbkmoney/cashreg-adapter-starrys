package com.rbkmoney.adapter.starrys.service.starrys.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.CorrectionType;
import com.rbkmoney.adapter.starrys.service.starrys.constant.DocumentType;
import com.rbkmoney.adapter.starrys.service.starrys.constant.NonCashType;
import com.rbkmoney.adapter.starrys.service.starrys.constant.TaxId;
import com.rbkmoney.adapter.starrys.service.starrys.model.Date;
import com.rbkmoney.adapter.starrys.service.starrys.model.Reason;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MakeCorrectionDocumentRequest extends Request {

    /**
     * Сумма коррекции наличными
     */
    @JsonProperty("Cash")
    private Integer cash;

    /**
     * Сумма коррекции безналичным
     *
     * @see NonCashType
     */
    @JsonProperty("NonCash")
    private Integer nonCash;

    /**
     * Тип документа коррекции (см.табл.16)
     * <p>
     * {@link DocumentType}
     */
    @JsonProperty("DocumentType")
    private int documentType;

    /**
     * Сумма оплаты предоплатой (зачётом аванса)
     */
    @JsonProperty("AdvancePayment")
    private Integer advancePayment;

    /**
     * Сумма оплаты постоплатой (в кредит)
     */
    @JsonProperty("Credit")
    private Integer credit;

    /**
     * Сумма оплаты встречным предоставлением
     */
    @JsonProperty("Consideration")
    private Integer consideration;

    /**
     * Применяемая в чеке система налогообложения (см.табл.11)
     */
    @JsonProperty("TaxMode")
    private Integer taxMode;

    /**
     * Суммы коррекции налогов в документе (см. табл. 33)
     *
     * @see TaxId
     */
    @JsonProperty("Tax")
    private Integer tax;

    /**
     * Тип коррекции(см.табл.17)
     *
     * @see CorrectionType
     */
    @JsonProperty("CorrectionType")
    private Integer correctionType;

    /**
     * Основание для коррекции
     *
     * @see Reason
     */
    @JsonProperty("Reason")
    private Reason reason;

    /**
     * Наименование документа
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Номер документа
     */
    @JsonProperty("Number")
    private String number;

    /**
     * Дата документа
     */
    @JsonProperty("Date")
    private Date date;

}
