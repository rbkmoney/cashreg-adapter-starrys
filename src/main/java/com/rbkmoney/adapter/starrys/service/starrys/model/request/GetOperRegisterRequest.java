package com.rbkmoney.adapter.starrys.service.starrys.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.Register;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetOperRegisterRequest extends Request {

    /**
     * Номер денежного регистра (см.табл.38)
     *
     * @see Register
     */
    @JsonProperty("Register")
    private int register;

}
