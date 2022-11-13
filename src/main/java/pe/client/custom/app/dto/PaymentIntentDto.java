package pe.client.custom.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import pe.client.custom.app.validation.annotation.EmailPatternValid;
import pe.client.custom.app.validation.annotation.PhonePatternValid;
import pe.client.custom.app.validation.annotation.PhoneTypeValid;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class PaymentIntentDto {
    @NotNull
    @EmailPatternValid
    @Schema(required = true, description = "Email de recepción", example = "arturo.lucas.pe@gmail.com")
    private String receiptEmail;
    @NotNull
    @PhonePatternValid
    @Schema(required = true, description = "Teléfono de recepción", example = "997785234")
    private String receiptPhone;
    @PhoneTypeValid
    @Schema(required = true, description = "Tipo de teléfono de recepción", example = "Movil")
    private String receiptPhoneType;
    @Valid
    @NotNull
    private MoneyDto payment;
    @Valid
    @NotNull
    private PaymentMethodDto paymentMethod;
    @Valid
    @NotNull
    private CardDto paymentTransfer;
    @Valid
    @NotNull
    private ClientDto client;
    @NotNull
    private String businessApplicationId;
}
