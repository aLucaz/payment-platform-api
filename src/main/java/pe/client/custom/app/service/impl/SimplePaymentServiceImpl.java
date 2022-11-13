package pe.client.custom.app.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import pe.client.custom.app.client.BankFeignClient;
import pe.client.custom.app.dto.PaymentIntentDto;
import pe.client.custom.app.dto.PaymentResponseDto;
import pe.client.custom.app.exception.InternalServerException;
import pe.client.custom.app.service.PaymentService;
import pe.client.custom.app.service.SecurityService;
import pe.client.custom.app.util.constant.Header;
import pe.client.custom.app.util.constant.Message;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class SimplePaymentServiceImpl implements PaymentService {

    private final BankFeignClient bankFeignClient;
    private final SecurityService securityService;

    public SimplePaymentServiceImpl(@Qualifier("bankFeignClient") BankFeignClient bankFeignClient,
                                    SecurityServiceImpl securityService) {
        this.bankFeignClient = bankFeignClient;
        this.securityService = securityService;
    }

    @Override
    public PaymentResponseDto pay(PaymentIntentDto paymentIntent) {
        Map<String, Object> body = getPayBody(paymentIntent);
        Map<String, Object> headers = getPayHeaders();
        var response = callBankService(body, headers);
        log.info("Bank transaction completed");
        return PaymentResponseDto.fromBankTransferResponse(response);
    }

    private Map<String, Object> getPayHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put(Header.X_AUTHORIZATION, "Bearer " + securityService.getToken());
        headers.put(Header.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        return headers;
    }

    private Map<String, Object> getPayBody(PaymentIntentDto paymentIntent) {
        Map<String, Object> body = new HashMap<>();
        body.put("exp_month", paymentIntent.getPaymentTransfer().getExpMonth());
        body.put("exp_year", paymentIntent.getPaymentTransfer().getExpYear());
        body.put("card_number", paymentIntent.getPaymentTransfer().getNumber());
        body.put("client_id", paymentIntent.getClient().getId());
        body.put("amount", paymentIntent.getPayment().getAmount());
        body.put("currency", paymentIntent.getPayment().getCurrency());
        body.put("business_application_id", paymentIntent.getBusinessApplicationId());
        return body;
    }

    private JsonNode callBankService(Map<String, Object> body, Map<String, Object> headers) {
        try {
            return bankFeignClient.transfer(body, headers);
        } catch (Exception ex) {
            log.error(Message.UNKNOWN_ERROR_LOG);
            log.error(ex.getMessage(), ex);
            throw new InternalServerException("An error occurred while calling bank server");
        }
    }
}
