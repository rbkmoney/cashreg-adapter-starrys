package com.rbkmoney.adapter.starrys.service.starrys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.DocumentType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Права: Кассир
 * Команда не оказывает влияния на фискальный накопитель. Команда игнорирует состояние принтера.
 * <p>
 * Условия выполнения команды:
 * 1. Документ закрыт
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenDocument {

    /**
     * Тип чека для добавляемой товарной позиции
     * {@link DocumentType}
     */
    @JsonProperty("DocumentType")
    private int documentType;

}
