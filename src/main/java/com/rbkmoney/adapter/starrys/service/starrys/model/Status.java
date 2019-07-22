package com.rbkmoney.adapter.starrys.service.starrys.model;

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
public class Status {

    /**
     * Версия ПО (массив из двух чисел)
     */
    @JsonProperty("Version")
    private String version;

    /**
     * Сборка ПО
     */
    @JsonProperty("Build")
    private String build;

    /**
     * Дата сборки ПО (см. п. 2.1.4)
     */
    @JsonProperty("SoftwareDate")
    private Date softwareDate;

    /**
     * Срок аренды (см. п. 2.1.4, п. 1.6)
     */
    @JsonProperty("LeasedTo")
    private Date leasedTo;

    /**
     * Код состояния устройства (см.табл.23)
     */
    @JsonProperty("Mode")
    private String mode;

    /**
     * Фаза жизни ФН (см.табл.6)
     */
    @JsonProperty("FNStatus")
    private String fNStatus;

    /**
     * Последнее состояние принтера (см.табл.5)
     *
     * @see com.rbkmoney.starrys.cashreg.starrys.constant.PrinterStatus
     */
    @JsonProperty("LastPrinterStatus")
    private String lastPrinterStatus;

    /**
     * Срок жизни ФН (см. п. 2.1.4)
     */
    @JsonProperty("FNExpirationDate")
    private String fnExpirationDate;

    /**
     * Флаги состояния ФН(см.табл.7)
     */
    @JsonProperty("FNFlags")
    private String fnFlags;

    /**
     * Текущий статус принтера (см.табл.5)
     *
     * @see com.rbkmoney.starrys.cashreg.starrys.constant.PrinterStatus
     */
    @JsonProperty("CurrentPrinterStatus")
    private String currentPrinterStatus;

    /**
     * Текущая дата устройства (см. п. 2.1.4)
     *
     * @see Date
     */
    @JsonProperty("CurrentDate")
    private Date currentDate;

    /**
     * Текущее время устройства (см. п. 2.1.4)
     *
     * @see Time
     */
    @JsonProperty("CurrentTime")
    private Time currentTime;

    /**
     * Режим аренды
     */
    @JsonProperty("LeaseMode")
    private String leaseMode;

    /**
     * Серийный номер фискального накопителя
     */
    @JsonProperty("FNSerialNumber")
    private String fnSerialNumber;

    /**
     * Номер последнего сформированного фискального документа
     */
    @JsonProperty("FNLastFiscalDocumentNumber")
    private String fnLastFiscalDocumentNumber;

    /**
     * Признак скорого завершения аренды
     */
    @JsonProperty("LeaseExpiredSoon")
    private String leaseExpiredSoon;

    /**
     * Дата и время последнего фискального документа
     *
     * @see DateTime
     */
    @JsonProperty("FNLastFiscalDocumentDate")
    private DateTime fnLastFiscalDocumentDate;

}
