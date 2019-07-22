package com.rbkmoney.adapter.starrys.service.starrys.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.FCEError;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Responses {

    /**
     * nil или строка с описанием ошибки выполнения
     */
    @JsonProperty("ExchangeError")
    private String exchangeError;

    /**
     * Path
     */
    @JsonProperty("Path")
    private String path;

    /**
     * Response
     */
    @JsonProperty("Response")
    private Response response;

    /**
     * Ошибки сервера FCE
     *
     * @see FCEError
     */
    @JsonProperty("FCEError")
    private Integer fceError;

    /**
     * содержит описание ошибки или дополнительную информацию.
     */
    @JsonProperty("ErrorDescription")
    private String errorDescription;

    /**
     * Fatal со значением true показывает, что повторное выполнение запроса приведёт к ошибке.
     */
    @JsonProperty("Fatal")
    private boolean fatal;

}
