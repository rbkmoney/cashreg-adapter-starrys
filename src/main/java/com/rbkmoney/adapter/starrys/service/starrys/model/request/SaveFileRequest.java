package com.rbkmoney.adapter.starrys.service.starrys.model.request;

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
public class SaveFileRequest extends Request {

    /**
     * Смещение относительно начала файла
     */
    @JsonProperty("Offset")
    private String offset;

    /**
     * Данные (строка в кодировке Base64)
     */
    @JsonProperty("Data")
    private String data;

}
