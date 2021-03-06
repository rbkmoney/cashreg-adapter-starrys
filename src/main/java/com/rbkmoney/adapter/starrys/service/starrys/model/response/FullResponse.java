package com.rbkmoney.adapter.starrys.service.starrys.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.model.Device;
import com.rbkmoney.adapter.starrys.service.starrys.model.FirstRequest;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FullResponse {

    @JsonProperty("ClientId")
    private String clientId;

    /**
     * @see Device
     */
    @JsonProperty("Device")
    private Device device;

    @JsonProperty("Path")
    private String path;

    @JsonProperty("RequestId")
    private String requestId;

    @JsonProperty("FCEError")
    private Integer fceError;

    @JsonProperty("ErrorDescription")
    private String errorDescription;

    @JsonProperty("Response")
    private Response response;

    @JsonProperty("ServerQueueLen")
    private Integer serverQueueLen;

    @JsonProperty("FirstRequest")
    private FirstRequest firstRequest;

    @JsonProperty("Responses")
    private List<Responses> responses;

}
