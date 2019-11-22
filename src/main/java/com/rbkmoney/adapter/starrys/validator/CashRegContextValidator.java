package com.rbkmoney.adapter.starrys.validator;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.OptionalField;
import com.rbkmoney.adapter.common.Validator;
import com.rbkmoney.damsel.cashreg.provider.CashRegContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CashRegContextValidator implements Validator<CashRegContext> {

    @Override
    public void validate(CashRegContext context) {
        Map<String, String> options = context.getOptions();
        validateRequredFields(options);
    }

    private void validateRequredFields(Map<String, String> options) {
        Objects.requireNonNull(options.get(OptionalField.URL.getField()), "Option 'url' must be set");
        Objects.requireNonNull(options.get(OptionalField.GROUP.getField()), "Option 'group' must be set");
        Objects.requireNonNull(options.get(OptionalField.COMPANY_NAME.getField()), "Option 'company' must be set");
        Objects.requireNonNull(options.get(OptionalField.COMPANY_ADDRESS.getField()), "Option 'companyAddress' must be set");
        Objects.requireNonNull(options.get(OptionalField.PASS.getField()), "Option 'pass' must be set");
    }
    
}
