package context;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private static Map<String, Object> contextMap = new HashMap<>();

    public static void set(String key, Object value) {
        contextMap.put(key, value);
    }

    public static Object get(String key) {
        return contextMap.get(key);
    }
}
