package com.rbkmoney.adapter.starrys.converter.entry;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.OptionalField;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.TargetType;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.converter.CashRegAdapterContextConverter;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.flow.TargetTypeResolver;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.*;
import com.rbkmoney.damsel.cashreg.Cart;
import com.rbkmoney.damsel.cashreg.ItemsLine;
import com.rbkmoney.damsel.cashreg.provider.CashRegContext;
import com.rbkmoney.damsel.cashreg_domain.PaymentInfo;
import com.rbkmoney.damsel.cashreg_domain.RussianLegalEntity;
import com.rbkmoney.damsel.cashreg_domain.TaxMode;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CtxToEntryModelConverter implements Converter<CashRegContext, EntryStateModel> {

    private final CashRegAdapterContextConverter cashRegAdapterContextConveter;

    @Override
    public EntryStateModel convert(CashRegContext context) {
        AdapterState adapterState = cashRegAdapterContextConveter.convert(context);

        Map<String, String> options = context.getOptions();
        EntryStateModel.EntryStateModelBuilder builder = EntryStateModel.builder();

        builder.options(context.getOptions());
        builder.cashRegId(context.getCashregId());

        builder.auth(Auth.builder()
                .login(options.get(OptionalField.LOGIN.getField()))
                .pass(options.get(OptionalField.PASS.getField()))
                .build());

        PaymentInfo paymentInfo = context.getSourceCreation().getPayment();
        builder.client(Client.builder()
                .email(paymentInfo.getEmail())
                .build()
        );

        RussianLegalEntity russianLegalEntity = context.getAccountInfo().getLegalEntity().getRussianLegalEntity();
        builder.company(Company.builder()
                .email(russianLegalEntity.getEmail())
                .inn(russianLegalEntity.getInn())
                .paymentAddress(russianLegalEntity.getActualAddress())
                .sno(TaxMode.findByValue(russianLegalEntity.getTaxMode().getValue()).name())
                .build()
        );

        builder.items(prepareCart(paymentInfo.getCart(), options));
        builder.total(prepareAmount(paymentInfo.getCash().getAmount()));

        List<ItemsLine> itemsLines = paymentInfo.getCart().getLines();
        builder.payments(itemsLines.stream().map(this::preparePayments).collect(Collectors.toList()));
        builder.vats(itemsLines.stream().map(this::prepareVat).collect(Collectors.toList()));

        TargetType targetType = TargetTypeResolver.resolve(context.getSession().getType());
        StateModel.StateModelBuilder stateModelBuilder = StateModel.builder()
                .targetType(targetType);

        if (adapterState != null) {
            stateModelBuilder.adapterContext(adapterState);
        }

        builder.state(stateModelBuilder.build());
        return builder.build();
    }

    private Vat prepareVat(ItemsLine itemsLine) {
        return Vat.builder()
                .sum(prepareAmount(itemsLine.getPrice().getAmount()))
                .type(itemsLine.getTax())
                .build();
    }

    private Payments preparePayments(ItemsLine itemsLine) {
        BigDecimal fullPriceAmount = prepareAmount(itemsLine.getPrice().getAmount() * itemsLine.getQuantity());
        // TODO: number 1
        return Payments.builder().sum(fullPriceAmount).type(1).build();
    }

    private BigDecimal prepareAmount(Long amount) {
        return new BigDecimal(amount).movePointLeft(2);
    }

    private List<Items> prepareCart(Cart cart, Map<String, String> options) {
        List<Items> itemsList = new ArrayList<>();
        cart.getLines().forEach(itemsLine -> {
            BigDecimal sum = prepareAmount(itemsLine.getPrice().getAmount() * itemsLine.getQuantity());
            itemsList.add(
                    Items.builder()
                            .quantity(new BigDecimal(itemsLine.getQuantity()).setScale(1))
                            .price(prepareAmount(itemsLine.getPrice().getAmount()))
                            .sum(sum)
                            .vat(Vat.builder().type(itemsLine.getTax()).build())
                            .paymentMethod(options.get(OptionalField.PAYMENT_METHOD.getField()))
                            .paymentObject(options.get(OptionalField.PAYMENT_OBJECT.getField()))
                            .name(itemsLine.getProduct())
                            .build()
            );
        });

        return itemsList;
    }

}
