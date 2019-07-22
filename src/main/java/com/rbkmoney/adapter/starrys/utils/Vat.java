package com.rbkmoney.adapter.starrys.utils;


import com.rbkmoney.adapter.starrys.service.starrys.constant.TaxId;

public enum Vat {

    VAT_0("0%", TaxId.VAT_0, "0% НДС"),
    VAT_10("10%", TaxId.VAT_10, "10% НДС"),
    VAT_18("18%", TaxId.VAT_18, "18% НДС"),
    VAT_20("20%", TaxId.VAT_18, "20% НДС"),
    NO_VAT("null", TaxId.NO_VAT, "Без НДС"),
    VAT_10_110("10/110", TaxId.VAT_10_110, "10/110 НДС"),
    VAT_18_118("18/118", TaxId.VAT_18_118, "18/118 НДС"),
    VAT_20_120("20/120", TaxId.VAT_20_120, "20/120 НДС");

    private final String codeText;
    private final Integer code;
    private final String message;


    Vat(String codeText, int code, String message) {
        this.codeText = codeText;
        this.code = code;
        this.message = message;
    }

    /**
     * Return the integer value of this vat code.
     *
     * @return int
     */
    public Integer getCode() {
        return code;
    }


    /**
     * Return the string value of this vat code text.
     *
     * @return int
     */
    public String getCodeText() {
        return codeText;
    }

    /**
     * Return the message of this vat code.
     *
     * @return String
     */
    public String getMessage() {
        return message;
    }

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
