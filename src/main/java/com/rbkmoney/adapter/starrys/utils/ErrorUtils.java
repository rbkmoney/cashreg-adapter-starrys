package com.rbkmoney.adapter.starrys.utils;

import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;

public class ErrorUtils {

    public static boolean hasError(FullResponse fullResponse) {
        return (fullResponse.getResponse().getError() != 0 && fullResponse.getResponse().getError() != null);
    }

}
