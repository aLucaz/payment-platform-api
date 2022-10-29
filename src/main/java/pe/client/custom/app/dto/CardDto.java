package pe.client.custom.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import pe.client.custom.app.validation.annotation.MonthPatternValid;
import pe.client.custom.app.validation.annotation.YearPatternValid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CardDto {
    @NotNull
    @MonthPatternValid
    @Size(min = 2, max = 2)
    @Schema(required = true, description = "Mes de expiración", example = "09")
    private String expMonth;
    @NotNull
    @YearPatternValid
    @Size(min = 2, max = 2)
    @Schema(required = true, description = "Año de expiración", example = "25")
    private String expYear;
    @NotNull
    @Size(min = 16, max = 16)
    @Schema(required = true, description = "Numero de tarjeta", example = "4994211113232123")
    private String number;
    @NotNull
    @Size(min = 3, max = 3)
    @Schema(required = true, description = "Código CVC", example = "009")
    private String cvc;
}
