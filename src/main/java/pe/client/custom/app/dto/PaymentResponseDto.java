package pe.client.custom.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Data;
import pe.client.custom.app.util.JsonUtil;
import pe.client.custom.app.util.constant.Message;

@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PaymentResponseDto {
    private String operationId;
    private String message;

    public static PaymentResponseDto fromBankTransferResponse(JsonNode response){
        return PaymentResponseDto.builder()
            .operationId(JsonUtil.getField("transactionIdentifier", response))
            .message(Message.TRANSACTION_COMPLETED)
            .build();
    }
}
