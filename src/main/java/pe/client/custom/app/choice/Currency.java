package pe.client.custom.app.choice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Currency {
    EUR("EUR"),
    BZD("BZD"),
    XOF("XOF"),
    BMD("BMD"),
    INR("INR"),
    BTN("BTN"),
    BOB("BOB"),
    BOV("BOV"),
    USD("USD");

    private final String description;
    public static final Map<String, String> ENUM_MAP;

    Currency(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    static {
        Map<String, String> map = new HashMap<>();
        for (Currency instance : Currency.values()) {
            map.put(instance.name(), instance.getDescription());
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static String get(String name) {
        return ENUM_MAP.get(name);
    }
}
