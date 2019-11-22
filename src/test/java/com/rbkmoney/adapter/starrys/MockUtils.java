package com.rbkmoney.adapter.starrys;


import com.rbkmoney.adapter.starrys.service.starrys.StarRysClient;
import com.rbkmoney.adapter.starrys.service.starrys.model.DateTime;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.Response;
import org.mockito.stubbing.Answer;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

public class MockUtils {

    public static void mockClient(StarRysClient client) {
        doAnswer((Answer<ResponseEntity<FullResponse>>) invocation -> {
            Response response = new Response();
            response.setRequestId("requestId");
            response.setDateTime(new DateTime());
            response.setFiscalDocNumber(1);
            response.setGrandTotal(2);
            response.setError(0);

            FullResponse fullResponse = new FullResponse();
            fullResponse.setRequestId("requestId");

            fullResponse.setResponse(response);
            return ResponseEntity.status(org.apache.http.HttpStatus.SC_OK).body(fullResponse);
        }).when(client).debit(any());
    }
}
