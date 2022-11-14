package pe.client.custom.app.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import pe.client.custom.app.util.constant.Api;

import java.util.Map;

@FeignClient(
    name = "security-feign-client",
    url = "${payment.platform.security.url}"
)
public interface SecurityFeignClient {

    @GetMapping(
        path = Api.API_GET_TOKEN_PATH
    )
    JsonNode getToken(@RequestParam Map<String, Object> params, @RequestHeader Map<String, Object> headers);

}
