package com.rbkmoney.adapter.starrys.service.starrys.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Права: Кассир
 * Команда не оказывает влияния на фискальный накопитель.
 * Команда игнорирует состояние принтера.
 * Условия выполнения команды: 1. Документ открыт
 *
 * @author Anatoly Cherkasov
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPhoneOrEmailOfCustomerRequest extends Request {

    /**
     * Телефон или электронный адрес покупателя
     * (номер телефона покупателя в формате (79ХХХХХХ))
     */
    @JsonProperty("Value")
    private String value;


    // ------------------------------------------------------------------------
    // Setters and Getters methods
    // ------------------------------------------------------------------------

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AddPhoneOrEmailOfCustomerRequest{" +
                "value='" + value + '\'' +
                '}';
    }
}
