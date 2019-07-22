package com.rbkmoney.adapter.starrys.service.starrys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FiscalDocument {

    /**
     * e.g. 1041
     */
    @JsonProperty("TagID")
    private Integer tagID;

    /**
     * e.g. string
     */
    @JsonProperty("TagType")
    private String tagType;

    /**
     * "9999078900005731"
     */
    @JsonProperty("Value")
    private List<FiscalDocumentValue> value;

}
