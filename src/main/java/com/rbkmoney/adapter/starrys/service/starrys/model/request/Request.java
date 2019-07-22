package com.rbkmoney.adapter.starrys.service.starrys.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.Device;
import com.rbkmoney.adapter.starrys.service.starrys.constant.Group;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
abstract class Request implements IRequest {

    /**
     * Уникальный идентификатор запроса
     */
    @JsonProperty("RequestId")
    protected String requestId;

    /**
     * Определяет в какой группе должно находиться устройство для отправки запроса
     *
     * @see Group
     */
    @JsonProperty("Group")
    protected String group;

    /**
     * Устройство
     *
     * @see Device
     */
    @JsonProperty("Device")
    protected String device;

    /**
     * Пароль команды
     */
    @JsonProperty("Password")
    protected Integer password;

}
