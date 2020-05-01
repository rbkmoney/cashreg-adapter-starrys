package com.rbkmoney.adapter.starrys.converter.exit;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.state.serializer.AdapterSerializer;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.creators.CashregAdapterCreators;
import com.rbkmoney.damsel.cashreg.adapter.CashregResult;
import com.rbkmoney.damsel.cashreg.adapter.Intent;
import com.rbkmoney.damsel.domain.Failure;
import com.rbkmoney.error.mapping.ErrorMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExitModelToProxyResultConverter implements Converter<ExitStateModel, CashregResult> {

    private final ErrorMapping errorMapping;
    private final AdapterSerializer serializer;

    @Override
    public CashregResult convert(ExitStateModel exitStateModel) {
        EntryStateModel entryStateModel = exitStateModel.getEntryStateModel();

        Intent intent = CashregAdapterCreators.createFinishIntentSuccess();
        if (exitStateModel.getErrorCode() != null) {
            Failure failure = errorMapping.mapFailure(exitStateModel.getErrorCode(), exitStateModel.getErrorMessage());
            intent = CashregAdapterCreators.createFinishIntentFailure(failure);
        }

        CashregResult cashRegResult = new CashregResult()
                .setIntent(intent)
                .setState(serializer.writeByte(entryStateModel.getState().getAdapterContext()));

        if (exitStateModel.getInfo() != null) {
            cashRegResult.setInfo(exitStateModel.getInfo());
        }

        return cashRegResult;
    }

}
