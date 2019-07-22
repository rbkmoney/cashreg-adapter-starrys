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
public class Ticket {

    /**
     * Дата и время квитанции
     */
    @JsonProperty("Date")
    private DateTime dateTime;

    /**
     * Фискальный признак ОФД
     */
    @JsonProperty("FDOSign")
    private String fdoSign;

    /**
     * Номер фискального документа,на который получена квитанция
     */
    @JsonProperty("FiscalDocNumber")
    private Integer fiscalDocNumber;

}
