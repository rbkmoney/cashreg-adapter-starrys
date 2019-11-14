package com.rbkmoney.adapter.starrys.utils;

import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import org.springframework.http.ResponseEntity;

public class ErrorUtils {

    public static boolean hasError(ResponseEntity<FullResponse> entity) {
        FullResponse fullResponse = entity.getBody();
        return (fullResponse != null
                && fullResponse.getResponse() != null
                && fullResponse.getResponse().getError() != null
                && fullResponse.getResponse().getError() != 0
        );
    }

}
