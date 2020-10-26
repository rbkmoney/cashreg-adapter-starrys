package com.rbkmoney.adapter.starrys.service.starrys;

import com.rbkmoney.adapter.starrys.service.starrys.model.request.ComplexRequest;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.RequestWrapper;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import org.springframework.http.ResponseEntity;

public interface AdapterCashReg {

    ResponseEntity<FullResponse> debit(RequestWrapper<ComplexRequest> request);

    ResponseEntity<FullResponse> credit(RequestWrapper<ComplexRequest> request);

    ResponseEntity<FullResponse> refundDebit(RequestWrapper<ComplexRequest> request);

    ResponseEntity<FullResponse> refundCredit(RequestWrapper<ComplexRequest> request);

}
