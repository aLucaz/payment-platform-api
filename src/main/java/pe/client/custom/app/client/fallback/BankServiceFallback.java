package pe.client.custom.app.client.fallback;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pe.client.custom.app.client.BankFeignClient;

import java.util.Map;

@Slf4j
@Component
@Qualifier("bankFallback")
public class BankServiceFallback implements BankFeignClient {
    @Override
    public JsonNode transfer(Map<String, Object> body, Map<String, String> headers) {
        log.info("Fallback called");
        return null;
    }
}
