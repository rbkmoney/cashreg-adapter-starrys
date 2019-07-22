package com.rbkmoney.adapter.starrys.service.starrys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Основание для коррекции
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reason {

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
     * {@link Date Date}
     */
    @JsonProperty("Date")
    private Date date;

}
