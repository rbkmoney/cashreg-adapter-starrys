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
public class FirstRequest {

    /**
     * Уникальный идентификатор запроса
     */
    @JsonProperty("RequestId")
    private String requestId;

    /**
     * @see Date
     */
    @JsonProperty("Date")
    private Date date;

    /**
     * @see Time
     */
    @JsonProperty("Time")
    private Time time;

}
