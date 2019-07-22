package com.rbkmoney.adapter.starrys.service.starrys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Date {

    /**
     * День
     */
    @JsonProperty("Day")
    private Integer day;

    /**
     * Месяц
     */
    @JsonProperty("Month")
    private Integer month;

    /**
     * Год
     */
    @JsonProperty("Year")
    private Integer year;

}
