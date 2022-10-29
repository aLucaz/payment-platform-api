package pe.client.custom.app.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.client.custom.app.dto.PaymentIntentDto;
import pe.client.custom.app.service.PaymentService;
import pe.client.custom.app.service.impl.SimplePaymentServiceImpl;
import pe.client.custom.app.util.constant.Api;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(path = Api.API_BASE_PATH)
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(SimplePaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(
        path = Api.API_PAY_SERVICE,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> payService(@Valid @RequestBody PaymentIntentDto request) {
        var response = paymentService.pay(request);
        return ResponseEntity.ok(response);
    }

}
