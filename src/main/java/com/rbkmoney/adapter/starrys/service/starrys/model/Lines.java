package com.rbkmoney.adapter.starrys.service.starrys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Data
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

    @JsonProperty("PayAttribute")
    private Integer payAttribute;

    @JsonProperty("TaxId")
    private Integer taxId;

    @JsonProperty("Description")
    private String description;

}
