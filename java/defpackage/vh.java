package defpackage;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
public class vh {
    private static final Map<Class<?>, vh$a> a = new HashMap();

    static {
        a.put(Boolean.class, new vh$1());
        a.put(Integer.class, new vh$2());
        a.put(Long.class, new vh$3());
        a.put(Double.class, new vh$4());
        a.put(String.class, new vh$5());
        a.put(String[].class, new vh$6());
        a.put(JSONArray.class, new vh$7());
    }

    public static JSONObject a(Bundle bundle) throws JSONException {
        JSONObject json = new JSONObject();
        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            if (value != null) {
                if (value instanceof List) {
                    JSONArray jsonArray = new JSONArray();
                    for (String stringValue : (List) value) {
                        jsonArray.put(stringValue);
                    }
                    json.put(key, jsonArray);
                } else if (value instanceof Bundle) {
                    json.put(key, vh.a((Bundle) value));
                } else {
                    vh$a setter = (vh$a) a.get(value.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + value.getClass());
                    }
                    setter.a(json, key, value);
                }
            }
        }
        return json;
    }

    public static Bundle a(JSONObject jsonObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> jsonIterator = jsonObject.keys();
        while (jsonIterator.hasNext()) {
            String key = (String) jsonIterator.next();
            Object value = jsonObject.get(key);
            if (!(value == null || value == JSONObject.NULL)) {
                if (value instanceof JSONObject) {
                    bundle.putBundle(key, vh.a((JSONObject) value));
                } else {
                    vh$a setter = (vh$a) a.get(value.getClass());
                    if (setter == null) {
                        throw new IllegalArgumentException("Unsupported type: " + value.getClass());
                    }
                    setter.a(bundle, key, value);
                }
            }
        }
        return bundle;
    }
}
