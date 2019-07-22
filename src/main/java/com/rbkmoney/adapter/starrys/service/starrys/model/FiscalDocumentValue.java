package com.rbkmoney.adapter.starrys.service.starrys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FiscalDocumentValue {

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
    private JsonNode value;

}
