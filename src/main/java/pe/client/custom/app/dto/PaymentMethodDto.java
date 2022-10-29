package pe.client.custom.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import pe.client.custom.app.validation.annotation.PaymentMethodTypeValid;

@Data
public class PaymentMethodDto {
    @PaymentMethodTypeValid
    @Schema(required = true, description = "Tipo de pago", example = "blik")
    private String type;
}
