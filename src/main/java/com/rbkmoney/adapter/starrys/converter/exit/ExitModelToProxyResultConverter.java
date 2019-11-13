package com.rbkmoney.adapter.starrys.converter.exit;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.state.serializer.AdapterSerializer;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.creators.CashRegProviderCreators;
import com.rbkmoney.damsel.cashreg.provider.CashRegResult;
import com.rbkmoney.damsel.cashreg.provider.Intent;
import com.rbkmoney.damsel.domain.Failure;
import com.rbkmoney.error.mapping.ErrorMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExitModelToProxyResultConverter implements Converter<ExitStateModel, CashRegResult> {

    private final ErrorMapping errorMapping;
    private final AdapterSerializer serializer;

    @Override
    public CashRegResult convert(ExitStateModel exitStateModel) {
        EntryStateModel entryStateModel = exitStateModel.getEntryStateModel();

        Intent intent = CashRegProviderCreators.createFinishIntentSuccess();
        if (exitStateModel.getErrorCode() != null) {
            Failure failure = errorMapping.getFailureByCodeAndDescription(
                    exitStateModel.getErrorCode(),
                    exitStateModel.getErrorMessage()
            );
            intent = CashRegProviderCreators.createFinishIntentFailure(failure);
        }

        CashRegResult cashRegResult = new CashRegResult()
                .setIntent(intent)
                .setState(serializer.writeByte(entryStateModel.getState().getAdapterContext()));

        if (exitStateModel.getCashRegInfo() != null) {
            cashRegResult.setCashregInfo(exitStateModel.getCashRegInfo());
        }

        return cashRegResult;
    }

}
