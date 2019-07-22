package com.rbkmoney.adapter.starrys.service.starrys.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Права: Кассир
 * Команда не оказывает влияния на фискальный накопитель.
 * Команда игнорирует состояние принтера.
 * Условия выполнения команды: 1. Документ открыт
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPhoneOfGetPaymentOperatorRequest extends Request {

    /**
     * Телефон оператора по приёму платежей
     */
    @JsonProperty("Value")
    private String value;
}
