package com.rbkmoney.adapter.starrys.utils;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Vat {

    VAT_0("0%", 3, "0% НДС"),
    VAT_10("10%", 2, "10% НДС"),
    VAT_18("18%", 1, "18% НДС"),
    VAT_20("20%", 1, "20% НДС"),
    NO_VAT("null", 4, "Без НДС"),
    VAT_10_110("10/110", 6, "10/110 НДС"),
    VAT_18_118("18/118", 5, "18/118 НДС"),
    VAT_20_120("20/120", 5, "20/120 НДС");

    private final String codeText;
    private final Integer code;
    private final String message;

    public static Vat codeTextOf(String codeText) {
        for (Vat vat : values()) {
            if (vat.codeText.equals(codeText)) {
                return vat;
            }
        }
        throw new IllegalArgumentException("No matching for [" + codeText + "]");
    }

}
