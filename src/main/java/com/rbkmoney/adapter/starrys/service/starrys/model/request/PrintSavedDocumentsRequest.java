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
public class PrintSavedDocumentsRequest extends Request {

    /**
     * Первый из запрашиваемых документов
     */
    @JsonProperty("First")
    private String first;

    /**
     * Последний из запрашиваемых документов
     */
    @JsonProperty("Last")
    private String last;

}
