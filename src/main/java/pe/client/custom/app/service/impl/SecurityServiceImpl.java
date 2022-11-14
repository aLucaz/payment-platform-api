package pe.client.custom.app.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import pe.client.custom.app.client.SecurityFeignClient;
import pe.client.custom.app.config.properties.SecurityClientInfo;
import pe.client.custom.app.exception.BadRequestException;
import pe.client.custom.app.exception.InternalServerException;
import pe.client.custom.app.exception.UnavailableException;
import pe.client.custom.app.service.SecurityService;
import pe.client.custom.app.util.JsonUtil;
import pe.client.custom.app.util.constant.Header;
import pe.client.custom.app.util.constant.Message;
import pe.client.custom.app.util.constant.Param;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class SecurityServiceImpl implements SecurityService {

    private final SecurityFeignClient securityFeignClient;
    private final SecurityClientInfo securityClientInfo;

    public SecurityServiceImpl(SecurityFeignClient securityFeignClient, SecurityClientInfo securityClientInfo) {
        this.securityFeignClient = securityFeignClient;
        this.securityClientInfo = securityClientInfo;
    }

    @Override
    public String getToken() {
        var params = getSecurityParams();
        var headers = getHeaders();
        JsonNode response = callSecurityLayer(params, headers);
        log.info("Security Token Obtained correctly");
        return JsonUtil.getField("access_token", response);
    }

    private Map<String, Object> getSecurityParams() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Param.GRANT_TYPE, securityClientInfo.getGrantType());
        parameters.put(Param.SCOPE, securityClientInfo.getScope());
        return parameters;
    }

    private Map<String, Object> getHeaders() {
        Map<String, Object> headers = new HashMap<>();
        // only authorized calls are allowed
        headers.put(Header.X_AUTHORIZATION, "Basic " + securityClientInfo.getAuthorizationToken());
        headers.put(Header.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        return headers;
    }

    private JsonNode callSecurityLayer(Map<String, Object> params, Map<String, Object> headers) {
        try {
            return this.securityFeignClient.getToken(params, headers);
        } catch (FeignException.ServiceUnavailable ex) {
            log.error("Security API error: service unavailable");
            log.error(ex.getMessage(), ex);
            throw new UnavailableException("Security layer not avaiable");
        } catch (FeignException.BadRequest ex) {
            log.error("Visa API error: bad request");
            log.error(ex.getMessage(), ex);
            throw new BadRequestException("Invalid input request values");
        } catch (Exception ex) {
            log.error(Message.UNKNOWN_ERROR_LOG);
            log.error(ex.getMessage(), ex);
            throw new InternalServerException("An Unknown error occurred while creating token");
        }
    }

}
