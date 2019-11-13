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
    public FullResponse debit(RequestWrapper<ComplexRequest> requestWrapper) {
        requestWrapper.getRequest().setDocumentType(DocumentType.DEBIT);
        ResponseEntity<FullResponse> responseEntity = api.complex(requestWrapper);
        return responseEntity.getBody();
    }

    @Override
    public FullResponse credit(RequestWrapper<ComplexRequest> requestWrapper) {
        requestWrapper.getRequest().setDocumentType(DocumentType.CREDIT);
        ResponseEntity<FullResponse> responseEntity = api.complex(requestWrapper);
        return responseEntity.getBody();
    }

    @Override
    public FullResponse refundDebit(RequestWrapper<ComplexRequest> requestWrapper) {
        requestWrapper.getRequest().setDocumentType(DocumentType.REFUND_DEBIT);
        ResponseEntity<FullResponse> responseEntity = api.complex(requestWrapper);
        return responseEntity.getBody();
    }

    @Override
    public FullResponse refundCredit(RequestWrapper<ComplexRequest> requestWrapper) {
        requestWrapper.getRequest().setDocumentType(DocumentType.REFUND_CREDIT);
        ResponseEntity<FullResponse> responseEntity = api.complex(requestWrapper);
        return responseEntity.getBody();
    }

    @Override
    public FullResponse status(RequestWrapper<ComplexRequest> request) {
        throw new RuntimeException();
    }

//    private final StarRysApi api;
//
//    @Override
//    public ResponseEntity<?> debit(CashRegContext context) {
//        String requestId = context.getRequestId();
//        Map<String, String> options = context.getOptions();
//        ComplexRequest complex = prepareComplexRequest(context, requestId, options, DocumentType.DEBIT);
//        log.info("Complex {} with requestId {}", complex, requestId);
//        try {
//            String url = options.getOrDefault(OptionsFields.URL, starrysProperties.getUrl());
//            api.setUrl(url);
//            ResponseEntity<FullResponse> responseEntity = api.complex(complex);
//            log.info("Complex response: body {}, status {} with requestId {}",
//                    responseEntity.getBody(), responseEntity.getStatusCodeValue(), requestId
//            );
//            return responseEntity;
//        } catch (JsonProcessingException e) {
//            String message = "Exception with requestId " + requestId;
//            log.error(message, e);
//            throw new RuntimeException(message, e);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> credit(CashRegContext context) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<?> refundDebit(CashRegContext context) {
//        String requestId = context.getRequestId();
//        Map<String, String> options = context.getOptions();
//        // TODO: enum
//        ComplexRequest complex = prepareComplexRequest(context, requestId, options, DocumentType.REFUND_DEBIT);
//        log.info("Complex {} with requestId {}", complex, requestId);
//        try {
//            String url = options.getOrDefault(OptionsFields.URL, starrysProperties.getUrl());
//            api.setUrl(url);
//            ResponseEntity<FullResponse> responseEntity = api.complex(complex);
//            log.info("Complex response: body {}, status {} with requestId {}",
//                    responseEntity.getBody(), responseEntity.getStatusCodeValue(), requestId
//            );
//            return responseEntity;
//        } catch (JsonProcessingException e) {
//            String message = "Exception with requestId " + requestId;
//            log.error(message, e);
//            throw new RuntimeException(message, e);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> refundCredit(CashRegContext context) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<?> getStatus(CashRegContext context) {
//        return null;
//    }
//
//    public List<Lines> prepareCart(List<ItemsLine> itemsLines, Map<String, String> options) {
//
//        List<Lines> linesList = new ArrayList<>();
//        if (!itemsLines.isEmpty()) {
//            // Cart
//            itemsLines.forEach(invoiceLine -> {
//                Lines item = new Lines();
//                item.setQty(BigInteger.valueOf(invoiceLine.getQuantity() * 1000));
//                item.setPrice(BigInteger.valueOf(invoiceLine.getPrice().getAmount()));
//
//                if (options.get(OptionsFields.PAYMENT_TYPE) != null) {
//                    item.setPayAttribute(Integer.valueOf(options.get(OptionsFields.PAYMENT_TYPE)));
//                } else {
//                    item.setPayAttribute(PayAttribute.FULL_PAYMENT_BEFORE);
//                }
//
//                // TODO: check
//                String invoiceTaxId = invoiceLine.getTax();
//                Integer taxId = (invoiceTaxId != null && !invoiceTaxId.isEmpty())
//                        ? Vat.codeTextOf(invoiceTaxId).getCode()
//                        : Vat.NO_VAT.getCode();
//                item.setTaxId(taxId);
//
//                item.setDescription(invoiceLine.getProduct());
//                linesList.add(item);
//            });
//
//        }
//
//        return linesList;
//    }
//
//    private ComplexRequest prepareComplexRequest(CashRegContext context, String requestId,
//                                                 Map<String, String> options, int documentType) {
//        ComplexRequest complex = new ComplexRequest();
//        complex.setDocumentType(documentType);
//
//        if (options.get(OptionsFields.GROUP) != null) {
//            complex.setGroup(options.get(OptionsFields.GROUP));
//        }
//
//        complex.setDevice(Device.AUTO);
//        complex.setRequestId(requestId);
//        complex.setPassword(Integer.valueOf(options.get(OptionsFields.PASS)));
//
//        // Items - begin
//        List<Lines> linesList = prepareCart(context.getPaymentInfo().getCart().getLines(), options);
//        complex.setLines(linesList);
//        // Items - end
//
//        if (linesList.isEmpty()) {
//            String message = String.format("Starrys. List items is empty");
//            log.error(message);
//            throw new IllegalArgumentException(message);
//        }
//
//        /**
//         * CARD / ECASH / OTHER
//         * @see com.rbkmoney.starrys.utils.api.constant.NonCashType
//         */
//        BigInteger[] nonCash = new BigInteger[]{
//                BigInteger.valueOf(context.getPaymentInfo().getCash().getAmount()),
//                BigInteger.valueOf(0),
//                BigInteger.valueOf(0)
//        };
//        complex.setNonCash(nonCash);
//
//        if (context.getAccountInfo().getCompanyInfo().getTaxMode() != null) {
//            // TODO: Parse value
//            complex.setTaxMode(context.getAccountInfo().getCompanyInfo().getTaxMode().getValue());
//        }
//
//        complex.setPhoneOrEmail(context.getPaymentInfo().getPayer().getContactInfo().getEmail());
//        complex.setFullResponse(FullResponseType.FALSE);
//        return complex;
//    }

}
