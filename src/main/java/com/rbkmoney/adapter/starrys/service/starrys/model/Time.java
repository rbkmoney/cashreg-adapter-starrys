package com.rbkmoney.adapter.starrys.service.starrys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Time {

    @JsonProperty("Hour")
    private Integer hour;

    @JsonProperty("Minute")
    private Integer minute;

    @JsonProperty("Second")
    private Integer second;

}
