package com.rbkmoney.adapter.starrys.handler;

import com.rbkmoney.adapter.starrys.AbstractIntegrationTest;
import com.rbkmoney.adapter.starrys.MockUtils;
import com.rbkmoney.adapter.starrys.service.starrys.StarRysClient;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.Response;
import com.rbkmoney.damsel.cashreg.adapter.CashregContext;
import com.rbkmoney.damsel.cashreg.adapter.CashregResult;
import com.rbkmoney.damsel.cashreg.receipt.type.Debit;
import com.rbkmoney.damsel.cashreg.receipt.type.Type;
import org.apache.thrift.TException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

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

    @Test
    public void failureTest() throws TException {
        doAnswer((Answer<ResponseEntity<FullResponse>>) invocation -> {
            ResponseEntity<FullResponse> response = new ResponseEntity(new FullResponse(), HttpStatus.ACCEPTED);
            response.getBody().setResponse(new Response());
            response.getBody().getResponse().setError(1);
            response.getBody().getResponse().setDescription("test");
            return response;
        }).when(client).debit(any());

        CashregContext context = makeCashregContext(Type.debit(new Debit()));
        CashregResult result = handler.register(context);
        assertTrue(result.getIntent().getFinish().getStatus().isSetFailure());
    }

}