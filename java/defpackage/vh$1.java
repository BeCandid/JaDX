package defpackage;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
class vh$1 implements vh$a {
    vh$1() {
    }

    public void a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putBoolean(key, ((Boolean) value).booleanValue());
    }

    public void a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
