package defpackage;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter */
class vh$2 implements vh$a {
    vh$2() {
    }

    public void a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putInt(key, ((Integer) value).intValue());
    }

    public void a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
