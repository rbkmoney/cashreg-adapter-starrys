package com.rbkmoney.adapter.starrys.service.starrys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.Pay;
import com.rbkmoney.adapter.starrys.service.starrys.constant.TaxId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TurnReport {

    /**
     * Тип документа, это значения так же является ключём массива
     */
    @JsonProperty("DocType")
    private String docType;

    /**
     * Количество документов данного типа в смене
     */
    @JsonProperty("Count")
    private Integer count;

    /**
     * Сумма итогов документов за смену
     */
    @JsonProperty("GrandTotal")
    private Integer grandTotal;

    /**
     * Сумма итогов документов за смену
     *
     * @see Pay
     */
    @JsonProperty("Pay")
    private String pay;

    /**
     * Итог сдачи
     */
    @JsonProperty("Change")
    private Integer change;

    /**
     * Итоги по налогам (см. табл. 33)
     *
     * @see TaxId
     */
    @JsonProperty("Tax")
    private Integer tax;

    /**
     * Итоги по базе налогообложения (см. табл. 33)
     *
     * @see TaxId
     */
    @JsonProperty("TaxBase")
    private Integer taxBase;

}
