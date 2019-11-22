package com.rbkmoney.adapter.starrys.service.starrys.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.adapter.starrys.service.starrys.constant.*;
import com.rbkmoney.adapter.starrys.service.starrys.model.Lines;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComplexRequest {

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

    @JsonProperty("Password")
    protected Integer password;

    /**
     * {@link DocumentType}
     */
    @JsonProperty("DocumentType")
    private int documentType;

//    /**
//     * Поле QueueLen определяет стратегия выбора устройства при значении "auto"
//     * в поле Device по размеру очереди на устройств для отправки документов в ОФД.
//     * Выбирается устройство длина очереди на котором не превышает значение, указанное в поле (в документах).
//     */
//    @JsonProperty("QueueLen")
//    private int queueLen;

    @JsonProperty("Lines")
    private List<Lines> lines;

    /**
     * Сумма оплаты наличными
     */
    @JsonProperty("Cash")
    private BigInteger cash;

    /**
     * Массив из 3-х элементов с суммами оплат 3-х типов
     *
     * @see NonCashType
     */
    @JsonProperty("NonCash")
    private BigInteger[] nonCash;

    /**
     * Сумма оплаты предоплатой (зачётом аванса)
     */
    @JsonProperty("AdvancePayment")
    private BigInteger advancePayment;

    /**
     * Сумма оплаты постоплатой (в кредит)
     */
    @JsonProperty("Credit")
    private BigInteger credit;

    /**
     * Сумма оплаты встречным предоставлением
     */
    @JsonProperty("Consideration")
    private BigInteger consideration;

    /**
     * Применяемая в чеке система налогообложения
     *
     * @see TaxMode
     */
    @JsonProperty("TaxMode")
    private Integer taxMode;

    /**
     * Телефон или электронный адрес покупателя
     */
    @JsonProperty("PhoneOrEmail")
    private String phoneOrEmail;

    /**
     * Место расчётов
     * В этом поле можно указать адрес сайта, на котором сделан чек.
     */
    @JsonProperty("Place")
    private String place;

    /**
     * Максимальное количество документов в одной смене.
     */
    @JsonProperty("MaxDocumentsInTurn")
    private Integer maxDocumentsInTurn;

    /**
     * Признак получения полного ответа
     * true — получение полного ответа по всем командам, из которого строится запрос, аналогичный ответу команды Batch;
     * false — получение сокращённого ответа
     */
    @JsonProperty("FullResponse")
    private boolean fullResponse;

}
