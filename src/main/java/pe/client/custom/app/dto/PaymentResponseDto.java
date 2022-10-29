package pe.client.custom.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PaymentResponseDto {
    private String operationId;
    private String message;
}
