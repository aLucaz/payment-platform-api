package pe.client.custom.app.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import pe.client.custom.app.client.fallback.BankServiceFallback;
import pe.client.custom.app.util.constant.Api;

import java.util.Map;

@Qualifier("bankFeignClient")
@FeignClient(
    name = "bank-feign-client",
    url = "${payment.platform.bank.url}",
    fallback = BankServiceFallback.class
)
public interface BankFeignClient {

    @PostMapping(
        path = Api.API_TRANSFER_PATH,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    JsonNode transfer(@RequestBody Map<String, Object> body, @RequestHeader Map<String, Object> headers);
}
