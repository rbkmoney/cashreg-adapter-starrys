package com.rbkmoney.adapter.starrys.service.starrys.model.request;

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
public class GetTableDataRequest extends Request {
    /**
     * Номер таблицы
     */
    @JsonProperty("Table")
    private Integer table;

    /**
     * Номер строки таблицы
     */
    @JsonProperty("Row")
    private Integer row;

}
