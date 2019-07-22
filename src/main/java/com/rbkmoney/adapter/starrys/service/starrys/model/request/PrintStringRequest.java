package com.rbkmoney.adapter.starrys.service.starrys.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.Font;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrintStringRequest extends Request {

    /**
     * Шрифт для печати (0 – жирный, 1 – обычный)
     *
     * @see Font
     */
    @JsonProperty("Font")
    private int font;

    /**
     * Текст для печати
     */
    @JsonProperty("Text")
    private String text;

}
