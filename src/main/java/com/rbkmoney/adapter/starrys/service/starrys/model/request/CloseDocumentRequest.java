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
public class CloseDocumentRequest extends Request {

    /**
     * Сумма оплаты наличными
     */
    @JsonProperty("Cash")
    private Integer cash;

    /**
     * Массив из 3-х элементов с суммами оплат 3-х типов
     *
     * @see com.rbkmoney.starrys.cashreg.starrys.constant.NonCashType
     */
    @JsonProperty("NonCash")
    private Integer[] nonCash;

    /**
     * Сумма оплаты постоплатой (в кредит)
     */
    @JsonProperty("Credit")
    private Integer credit;

    /**
     * Сумма оплаты встречным предоставлением
     */
    @JsonProperty("Consideration")
    private Integer consideration;

    /**
     * Режим извлечения документа из архива фискального накопителя:
     * true   Не извлекать;
     * false   Извлекать
     *
     * @see com.rbkmoney.starrys.cashreg.starrys.constant.NoFetch
     */
    @JsonProperty("NoFetch")
    private Integer noFetch;

    /**
     * Режим сохранения документа в памяти устройства:
     * true - Не сохранять
     * false - сохранять
     *
     * @see com.rbkmoney.starrys.cashreg.starrys.constant.NoRender
     */
    @JsonProperty("NoRender")
    private boolean noRender;

}
