package defpackage;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
class vh$3 implements vh$a {
    vh$3() {
    }

    public void a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putLong(key, ((Long) value).longValue());
    }

    public void a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
