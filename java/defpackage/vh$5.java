package defpackage;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
class vh$5 implements vh$a {
    vh$5() {
    }

    public void a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putString(key, (String) value);
    }

    public void a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
