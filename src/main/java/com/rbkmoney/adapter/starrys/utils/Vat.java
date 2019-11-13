package com.rbkmoney.adapter.starrys.utils;


import com.rbkmoney.adapter.starrys.service.starrys.constant.TaxId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Vat {

    VAT_0("0%", TaxId.VAT_0, "0% НДС"),
    VAT_10("10%", TaxId.VAT_10, "10% НДС"),
    VAT_18("18%", TaxId.VAT_18, "18% НДС"),
    VAT_20("20%", TaxId.VAT_20, "20% НДС"),
    NO_VAT("null", TaxId.NO_VAT, "Без НДС"),
    VAT_10_110("10/110", TaxId.VAT_10_110, "10/110 НДС"),
    VAT_18_118("18/118", TaxId.VAT_18_118, "18/118 НДС"),
    VAT_20_120("20/120", TaxId.VAT_20_120, "20/120 НДС");

    private final String codeText;
    private final Integer code;
    private final String message;


    /**
     * Return the enum constant of this type with the specified numeric value.
     *
     * @param codeText the string value of the enum to be returned
     * @return the enum constant with the specified numeric value
     * @throws IllegalArgumentException if this enum has no constant for the specified numeric value
     */
    public static Vat codeTextOf(String codeText) {
        for (Vat vat : values()) {
            if (vat.codeText.equals(codeText)) {
                return vat;
            }
        }
        throw new IllegalArgumentException("No matching for [" + codeText + "]");
    }

}
