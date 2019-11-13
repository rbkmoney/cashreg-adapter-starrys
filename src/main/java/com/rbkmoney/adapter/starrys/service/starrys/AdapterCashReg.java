package com.rbkmoney.adapter.starrys.service.starrys;

import com.rbkmoney.adapter.starrys.service.starrys.model.request.ComplexRequest;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.RequestWrapper;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;

public interface AdapterCashReg {

    FullResponse debit(RequestWrapper<ComplexRequest> request);

    FullResponse credit(RequestWrapper<ComplexRequest> request);

    FullResponse refundDebit(RequestWrapper<ComplexRequest> request);

    FullResponse refundCredit(RequestWrapper<ComplexRequest> request);

    FullResponse status(RequestWrapper<ComplexRequest> request);

}
