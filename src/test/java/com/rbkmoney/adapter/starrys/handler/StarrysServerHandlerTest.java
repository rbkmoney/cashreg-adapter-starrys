package com.rbkmoney.adapter.starrys.handler;

import com.rbkmoney.adapter.starrys.AbstractIntegrationTest;
import com.rbkmoney.adapter.starrys.MockUtils;
import com.rbkmoney.adapter.starrys.service.starrys.StarRysClient;
import com.rbkmoney.damsel.cashreg.adapter.CashregContext;
import com.rbkmoney.damsel.cashreg.adapter.CashregResult;
import com.rbkmoney.damsel.cashreg.receipt.type.Debit;
import com.rbkmoney.damsel.cashreg.receipt.type.Type;
import org.apache.thrift.TException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertTrue;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class StarrysServerHandlerTest extends AbstractIntegrationTest {

    @MockBean
    public StarRysClient client;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        MockUtils.mockClient(client);
    }

    @Test
    public void testRegister() throws TException {
        CashregContext cashRegContext = makeCashregContext(Type.debit(new Debit()));
        CashregResult result = handler.register(cashRegContext);
        assertTrue(result.getIntent().isSetFinish());
    }

}