package com.rbkmoney.adapter.starrys.service.starrys.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.Pay;
import com.rbkmoney.adapter.starrys.service.starrys.model.TurnReport;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloseTurnRequest extends Request {

    /**
     * Номер фискального документа
     */
    @JsonProperty("FiscalDocNumber")
    private Integer fiscalDocNumber;

    /**
     * Номер фискального документа
     */
    @JsonProperty("TurnNumber")
    private String turnNumber;

    /**
     * Структура отчёта о закрытии смены
     */
    @JsonProperty("TurnReport")
    private TurnReport turnReport;

    /**
     * Сумма итогов документов за смену
     */
    @JsonProperty("GrandTotal")
    private Integer grandTotal;

    /**
     * Сумма итогов документов за смену
     *
     * @see Pay
     */
    @JsonProperty("Pay")
    private String pay;

    /**
     * Итог сдачи
     */
    @JsonProperty("Change")
    private Integer change;

    /**
     * Итоги по налогам (см. табл. 33)
     *
     * @see com.rbkmoney.starrys.cashreg.starrys.constant.TaxId
     */
    @JsonProperty("Tax")
    private Integer tax;

    /**
     * Итоги по базе налогообложения (см. табл. 33)
     *
     * @see com.rbkmoney.starrys.cashreg.starrys.constant.TaxId
     */
    @JsonProperty("TaxBase")
    private Integer taxBase;

    /**
     * Фискальный документ из архива ФН
     */
    @JsonProperty("FiscalDocument")
    private String fiscalDocument;

}
