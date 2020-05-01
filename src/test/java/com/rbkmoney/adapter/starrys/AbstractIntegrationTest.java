package com.rbkmoney.adapter.starrys;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.constant.OptionalField;
import com.rbkmoney.damsel.cashreg.adapter.CashregAdapterSrv;
import com.rbkmoney.damsel.cashreg.adapter.CashregContext;
import com.rbkmoney.damsel.cashreg.adapter.Session;
import com.rbkmoney.damsel.cashreg.adapter.SourceCreation;
import com.rbkmoney.damsel.cashreg.domain.AccountInfo;
import com.rbkmoney.damsel.cashreg.domain.PaymentInfo;
import com.rbkmoney.damsel.cashreg.domain.TaxMode;
import com.rbkmoney.damsel.cashreg.receipt.Cart;
import com.rbkmoney.damsel.cashreg.receipt.ItemsLine;
import com.rbkmoney.damsel.cashreg.receipt.type.Type;
import com.rbkmoney.damsel.domain.Cash;
import com.rbkmoney.damsel.domain.CurrencyRef;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
@ContextConfiguration(classes = CashregStarrysApplication.class)
public abstract class AbstractIntegrationTest {

    @Autowired
    protected CashregAdapterSrv.Iface handler;

    public CashregContext makeCashregContext(Type type) {
        return new CashregContext()
                .setCashregId(TestData.CASHREG_ID)
                .setSourceCreation(createSourceCreation())
                .setAccountInfo(createAccountInfo())
                .setOptions(createAdapterOptions())
                .setSession(new Session().setType(type));
    }

    protected Map<String, String> createAdapterOptions() {
        Map<String, String> options = new HashMap<>();
        options.put(OptionalField.LOGIN.getField(), "login");
        options.put(OptionalField.PASS.getField(), "1");
        options.put(OptionalField.PAYMENT_METHOD.getField(), "PAYMENT_METHOD");
        options.put(OptionalField.PAYMENT_OBJECT.getField(), "PAYMENT_OBJECT");
        options.put(OptionalField.GROUP.getField(), "Main");
        options.put(OptionalField.COMPANY_NAME.getField(), "Bull");
        options.put(OptionalField.COMPANY_ADDRESS.getField(), "street Tester");
        options.put(OptionalField.URL.getField(), "http://localhost/test_url");
        return options;
    }

    protected SourceCreation createSourceCreation() {
        SourceCreation sourceCreation = new SourceCreation();
        sourceCreation.setPayment(createPaymentInfo());
        return sourceCreation;
    }

    protected AccountInfo createAccountInfo() {
        com.rbkmoney.damsel.cashreg.domain.LegalEntity legalEntity = new com.rbkmoney.damsel.cashreg.domain.LegalEntity();
        com.rbkmoney.damsel.cashreg.domain.RussianLegalEntity russianLegalEntity = new com.rbkmoney.damsel.cashreg.domain.RussianLegalEntity();

        russianLegalEntity.setActualAddress("ActualAddress");
        russianLegalEntity.setInn("INN");
        russianLegalEntity.setPostAddress("PostAddress");
        russianLegalEntity.setRegisteredName("RegisteredName");
        russianLegalEntity.setRepresentativeDocument("RepresentativeDocument");
        russianLegalEntity.setRepresentativeFullName("RepresentativeFullName");
        russianLegalEntity.setRepresentativePosition("RepresentativePosition");
        russianLegalEntity.setRegisteredNumber("RegisteredNumber");

        com.rbkmoney.damsel.cashreg.domain.RussianBankAccount russianBankAccount = new com.rbkmoney.damsel.cashreg.domain.RussianBankAccount();
        russianBankAccount.setAccount("Account");
        russianBankAccount.setBankName("BankName");
        russianBankAccount.setBankPostAccount("BankPostAccount");
        russianBankAccount.setBankBik("BankBik");
        russianLegalEntity.setRussianBankAccount(russianBankAccount);
        russianLegalEntity.setEmail(TestData.TEST_EMAIL);
        russianLegalEntity.setTaxMode(TaxMode.osn);

        legalEntity.setRussianLegalEntity(russianLegalEntity);

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setLegalEntity(legalEntity);
        return accountInfo;
    }

    public static PaymentInfo createPaymentInfo() {
        PaymentInfo paymentInfo = new PaymentInfo();
        Cash cash = new Cash();
        cash.setAmount(100L);
        cash.setCurrency(new CurrencyRef().setSymbolicCode("RUR"));
        paymentInfo.setCash(cash);

        Cart cart = new Cart();
        List<ItemsLine> lines = new ArrayList<>();
        cart.setLines(lines);
        paymentInfo.setCart(cart);
        paymentInfo.setEmail(TestData.TEST_EMAIL);
        return paymentInfo;
    }

}
