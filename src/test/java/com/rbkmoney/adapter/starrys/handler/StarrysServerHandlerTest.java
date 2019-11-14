package com.rbkmoney.adapter.starrys.handler;


import com.rbkmoney.adapter.starrys.IntegrationTest;
import com.rbkmoney.adapter.starrys.MockUtils;
import com.rbkmoney.adapter.starrys.service.starrys.StarRysClient;
import com.rbkmoney.damsel.cashreg.provider.CashRegContext;
import com.rbkmoney.damsel.cashreg.provider.CashRegResult;
import org.apache.thrift.TException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import static junit.framework.TestCase.assertTrue;

public class StarrysServerHandlerTest extends IntegrationTest {

    @MockBean
    public StarRysClient client;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        MockUtils.mockClient(client);
    }

    @Test
    public void testRegister() throws TException {
        CashRegContext cashRegContext = makeCashRegContext();
        CashRegResult result = handler.register(cashRegContext);
        assertTrue(result.getIntent().isSetFinish());
    }

}