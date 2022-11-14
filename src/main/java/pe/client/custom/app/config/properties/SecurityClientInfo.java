package pe.client.custom.app.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "security.client.bank.info")
public class SecurityClientInfo {
    private String grantType;
    private String scope;
    private String authorizationToken;
}
