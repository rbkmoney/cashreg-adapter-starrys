package com.rbkmoney.adapter.starrys.service.starrys.model.response;

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
public class Responses {

    @JsonProperty("ExchangeError")
    private String exchangeError;

    @JsonProperty("Path")
    private String path;

    @JsonProperty("Response")
    private Response response;

    @JsonProperty("FCEError")
    private Integer fceError;

    @JsonProperty("ErrorDescription")
    private String errorDescription;

    @JsonProperty("Fatal")
    private boolean fatal;

}
