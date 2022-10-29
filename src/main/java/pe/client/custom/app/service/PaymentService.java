package pe.client.custom.app.service;

import pe.client.custom.app.dto.PaymentIntentDto;
import pe.client.custom.app.dto.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto pay(PaymentIntentDto paymentIntent);
}
