package pe.client.custom.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import pe.client.custom.app.validation.annotation.CurrencyValid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class MoneyDto {
    @NotNull
    @Schema(required = true, description = "Cantidad de dinero a transferir", example = "999.99")
    private Double amount;
    @NotNull
    @CurrencyValid
    @Size(min = 3, max = 3)
    @Schema(required = true, description = "Código de la moneda", example = "USD")
    private String currency;
}
