package com.rbkmoney.adapter.starrys.service.starrys;

import com.rbkmoney.adapter.starrys.service.starrys.constant.DocumentType;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.ComplexRequest;
import com.rbkmoney.adapter.starrys.service.starrys.model.request.RequestWrapper;
import com.rbkmoney.adapter.starrys.service.starrys.model.response.FullResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
@RequiredArgsConstructor
public class StarRysClient implements AdapterCashReg {

    private final StarRysApi api;

    @Override
    public ResponseEntity<FullResponse> debit(RequestWrapper<ComplexRequest> requestWrapper) {
        requestWrapper.getRequest().setDocumentType(DocumentType.DEBIT);
        return api.complex(requestWrapper);
    }

    @Override
    public ResponseEntity<FullResponse> credit(RequestWrapper<ComplexRequest> requestWrapper) {
        requestWrapper.getRequest().setDocumentType(DocumentType.CREDIT);
        return api.complex(requestWrapper);
    }

    @Override
    public ResponseEntity<FullResponse> refundDebit(RequestWrapper<ComplexRequest> requestWrapper) {
        requestWrapper.getRequest().setDocumentType(DocumentType.REFUND_DEBIT);
        return api.complex(requestWrapper);
    }

    @Override
    public ResponseEntity<FullResponse> refundCredit(RequestWrapper<ComplexRequest> requestWrapper) {
        requestWrapper.getRequest().setDocumentType(DocumentType.REFUND_CREDIT);
        return api.complex(requestWrapper);
    }

    @Override
    public ResponseEntity<FullResponse> status(RequestWrapper<ComplexRequest> request) {
        throw new RuntimeException();
    }

}
