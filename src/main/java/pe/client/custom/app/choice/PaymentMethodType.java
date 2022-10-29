package pe.client.custom.app.choice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum PaymentMethodType {
    ACSS_DEBIT("acss_debit"),
    AFFIRM("affirm"),
    AFTERPAY_CLEARPAY("afterpay_clearpay"),
    ALIPAY("alipay"),
    AU_BECS_DEBIT("au_becs_debit"),
    BACS_DEBIT("bacs_debit"),
    BANCONTACT("bancontact"),
    BLIK("blik");

    private final String description;
    public static final Map<String, String> ENUM_MAP;

    PaymentMethodType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    static {
        Map<String, String> map = new HashMap<>();
        for (PaymentMethodType instance : PaymentMethodType.values()) {
            map.put(instance.name(), instance.getDescription());
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static String get(String name) {
        return ENUM_MAP.get(name);
    }
}
