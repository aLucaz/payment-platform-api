package pe.client.custom.app.service.impl;

import org.springframework.stereotype.Service;
import pe.client.custom.app.dto.PaymentIntentDto;
import pe.client.custom.app.dto.PaymentResponseDto;
import pe.client.custom.app.service.PaymentService;

@Service
public class SimplePaymentServiceImpl implements PaymentService {

    @Override
    public PaymentResponseDto pay(PaymentIntentDto paymentIntent) {
        return null;
    }
}
