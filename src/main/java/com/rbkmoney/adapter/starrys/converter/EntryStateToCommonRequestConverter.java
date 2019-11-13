package com.rbkmoney.adapter.starrys.converter;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.config.properties.AdapterCashRegProperties;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.OptionalField;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.Items;
import com.rbkmoney.adapter.starrys.service.starrys.constant.Device;
import com.rbkmoney.adapter.starrys.service.starrys.constant.FullResponseType;
import com.rbkmoney.adapter.starrys.service.starrys.constant.PayAttribute;
import com.rbkmoney.adapter.starrys.service.starrys.model.Lines;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.ComplexRequest;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.RequestWrapper;
import com.rbkmoney.adapter.starrys.utils.Vat;
import com.rbkmoney.damsel.cashreg_domain.TaxMode;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.rbkmoney.adapter.starrys.service.starrys.constant.TaxMode.*;


@Component
@RequiredArgsConstructor
public class EntryStateToCommonRequestConverter implements Converter<EntryStateModel, RequestWrapper<ComplexRequest>> {

    private static final String DEFAULT_EMPTY_VALUE_TOKEN_API = "";

    private final AdapterCashRegProperties adapterCashRegProperties;

    @Override
    public RequestWrapper<ComplexRequest> convert(EntryStateModel entryStateModel) {

        ComplexRequest request = new ComplexRequest();
        request.setRequestId(entryStateModel.getCashRegId());
        request.setDevice(Device.AUTO);
        request.setPassword(Integer.valueOf(entryStateModel.getAuth().getPass()));
        request.setFullResponse(FullResponseType.FALSE);

        request.setCash(entryStateModel.getTotal().movePointRight(2).toBigInteger());

        /**
         * CARD / ECASH / OTHER
         * @see com.rbkmoney.starrys.utils.api.constant.NonCashType
         */
        BigInteger[] nonCash = new BigInteger[]{
                BigInteger.valueOf(entryStateModel.getTotal().movePointRight(2).longValue()),
                BigInteger.valueOf(0),
                BigInteger.valueOf(0)
        };
        request.setNonCash(nonCash);

        request.setPhoneOrEmail(entryStateModel.getClient().getEmail());

        String group = entryStateModel.getOptions().get(OptionalField.GROUP.getField());
        if (group != null) {
            request.setGroup(group);
        }

        List<Lines> linesList = prepareCart(entryStateModel.getItems(), entryStateModel.getOptions());
        request.setLines(linesList);

        if (entryStateModel.getCompany().getSno() != null) {
            request.setTaxMode(convertTaxMode(entryStateModel.getCompany().getSno()));
        }

        return new RequestWrapper<>(
                request,
                entryStateModel.getOptions().getOrDefault(OptionalField.URL.getField(), adapterCashRegProperties.getUrl()),
                entryStateModel.getOptions().get(OptionalField.GROUP.getField()),
                entryStateModel.getOptions().get(OptionalField.COMPANY_NAME.getField()),
                entryStateModel.getOptions().get(OptionalField.COMPANY_ADDRESS.getField()),
                entryStateModel.getOptions().get(com.rbkmoney.adapter.starrys.service.starrys.constant.OptionalField.DEVICE.getField()),
                entryStateModel.getOptions().get(OptionalField.PASS.getField()),
                DEFAULT_EMPTY_VALUE_TOKEN_API
        );
    }

    private static Integer convertTaxMode(String taxMode) {
        TaxMode cashregTaxMode = TaxMode.valueOf(taxMode);
        switch (cashregTaxMode) {
            case osn:
                return TOTAL;
            case usn_income:
                return SIMPLIFIED_INCOME;
            case usn_income_outcome:
                return SIMPLIFIED_REVENUE_MINUS_CONSUMPTION;
            case envd:
                return A_SINGLE_TAX_ON_IMPUTED_INCOME;
            case esn:
                return UNIFIED_AGRICULTURAL_TAX;
            case patent:
                return PATENT_SYSTEM_OF_TAXATION;
            default:
                return 0;
        }

    }

    private List<Lines> prepareCart(List<Items> itemsList, Map<String, String> options) {
        return itemsList.stream().map(items -> getLines(options, items)).collect(Collectors.toList());
    }

    private Lines getLines(Map<String, String> options, Items items) {
        Lines lines = new Lines();
        lines.setQty(items.getQuantity().multiply(new BigDecimal(1000)).toBigInteger());
        lines.setPrice(items.getPrice().movePointRight(2).toBigInteger());

        if (options.get(com.rbkmoney.adapter.starrys.service.starrys.constant.OptionalField.PAYMENT_TYPE.getField()) != null) {
            lines.setPayAttribute(Integer.valueOf(options.get(com.rbkmoney.adapter.starrys.service.starrys.constant.OptionalField.PAYMENT_TYPE.getField())));
        } else {
            lines.setPayAttribute(PayAttribute.FULL_PAYMENT_BEFORE);
        }

        // TODO: check
        String invoiceTaxId = items.getVat().getType();
        Integer taxId = (invoiceTaxId != null && !invoiceTaxId.isEmpty())
                ? Vat.codeTextOf(invoiceTaxId).getCode()
                : Vat.NO_VAT.getCode();
        lines.setTaxId(taxId);

        lines.setDescription(items.getName());

        return lines;
    }

}

