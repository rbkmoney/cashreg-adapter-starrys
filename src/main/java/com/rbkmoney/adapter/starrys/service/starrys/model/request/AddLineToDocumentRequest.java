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
 * <p>
 * Условия выполнения команды:
 * 1. Смена открыта
 * 2. В документе не должно быть операций других типов
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddLineToDocumentRequest extends Request {

    /**
     * Тип чека для добавляемой товарной позиции
     * {@link com.rbkmoney.adapter.starrys.service.starrys.constant.DocumentType}
     */
    @JsonProperty("DocumentType")
    private int documentType;

    /**
     * (Quantity): Количество
     * e.g. 1000
     */
    @JsonProperty("Qty")
    private Integer qty;

    /**
     * (Money): Цена
     * e.g. 1000
     */
    @JsonProperty("Price")
    private Integer price;

    /**
     * Признак способа расчёта
     * {@link com.rbkmoney.adapter.starrys.service.starrys.constant.PayAttribute}
     */
    @JsonProperty("PayAttribute")
    private Integer payAttribute;

    /**
     * Код налога
     *
     * @see com.rbkmoney.adapter.starrys.service.starrys.constant.TaxId
     */
    @JsonProperty("TaxId")
    private Integer taxId;

    /**
     * Наименование товарной позиции
     */
    @JsonProperty("Description")
    private Integer description;
}
