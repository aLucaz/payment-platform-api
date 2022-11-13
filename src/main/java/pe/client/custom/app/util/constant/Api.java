package pe.client.custom.app.util.constant;

public class Api {

    private Api() {
    }

    public static final String API_VERSION = "/v1.0";
    public static final String API_BASE_PATH = API_VERSION + "/api/payment";
    public static final String API_PAY_SERVICE = "/pay";
    public static final String API_PAY_SERVICE_PATH = API_BASE_PATH + API_PAY_SERVICE;
    public static final String API_TRANSFER = "/transfer";
    public static final String API_TRANSFER_PATH = API_VERSION + "/payment/bank" + API_TRANSFER;

    public static final String SECURITY_API_VERSION = "/v1.0";
    public static final String SECURITY_API_BASE_PATH = SECURITY_API_VERSION + "/payment/security";
    public static final String API_GET_TOKEN = "/token";
    public static final String API_GET_TOKEN_PATH = SECURITY_API_BASE_PATH + API_GET_TOKEN;
}
