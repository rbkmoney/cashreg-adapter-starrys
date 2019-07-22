package com.rbkmoney.adapter.starrys.service.starrys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.PayAttribute;
import com.rbkmoney.adapter.starrys.service.starrys.constant.TaxId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lines {

    /**
     * (Quantity): Количество
     * e.g. 1000
     */
    @JsonProperty("Qty")
    private BigInteger qty;

    /**
     * (Money): Цена
     * e.g. 1000
     */
    @JsonProperty("Price")
    private BigInteger price;

    /**
     * Признак способа расчёта
     *
     * @see PayAttribute
     */
    @JsonProperty("PayAttribute")
    private Integer payAttribute;

    /**
     * Код налога
     *
     * @see TaxId
     */
    @JsonProperty("TaxId")
    private Integer taxId;

    /**
     * Наименование товарной позиции
     */
    @JsonProperty("Description")
    private String description;

}
