package pe.client.custom.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ClientDto {
    @NotNull
    @Size(min = 9, max = 9)
    @Schema(required = true, description = "Id del cliente", example = "TSTCLIENT")
    private String id;
}
