package defpackage;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MetaDataStore */
class tn {
    private static final Charset a = Charset.forName("UTF-8");
    private final File b;

    public tn(File filesDir) {
        this.b = filesDir;
    }

    public tw a(String sessionId) {
        Exception e;
        Throwable th;
        File f = c(sessionId);
        if (!f.exists()) {
            return tw.a;
        }
        InputStream is = null;
        try {
            InputStream is2 = new FileInputStream(f);
            try {
                tw e2 = tn.e(CommonUtils.a(is2));
                CommonUtils.a(is2, "Failed to close user metadata file.");
                return e2;
            } catch (Exception e3) {
                e = e3;
                is = is2;
                try {
                    akx.h().e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.a(is, "Failed to close user metadata file.");
                    return tw.a;
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.a(is, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                is = is2;
                CommonUtils.a(is, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            akx.h().e("CrashlyticsCore", "Error deserializing user metadata.", e);
            CommonUtils.a(is, "Failed to close user metadata file.");
            return tw.a;
        }
    }

    public Map<String, String> b(String sessionId) {
        Exception e;
        Throwable th;
        File f = d(sessionId);
        if (!f.exists()) {
            return Collections.emptyMap();
        }
        InputStream is = null;
        try {
            InputStream is2 = new FileInputStream(f);
            try {
                Map<String, String> f2 = tn.f(CommonUtils.a(is2));
                CommonUtils.a(is2, "Failed to close user metadata file.");
                return f2;
            } catch (Exception e2) {
                e = e2;
                is = is2;
                try {
                    akx.h().e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.a(is, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.a(is, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                is = is2;
                CommonUtils.a(is, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            akx.h().e("CrashlyticsCore", "Error deserializing user metadata.", e);
            CommonUtils.a(is, "Failed to close user metadata file.");
            return Collections.emptyMap();
        }
    }

    private File c(String sessionId) {
        return new File(this.b, sessionId + "user" + ".meta");
    }

    private File d(String sessionId) {
        return new File(this.b, sessionId + "keys" + ".meta");
    }

    private static tw e(String json) throws JSONException {
        JSONObject dataObj = new JSONObject(json);
        return new tw(tn.a(dataObj, "userId"), tn.a(dataObj, "userName"), tn.a(dataObj, "userEmail"));
    }

    private static Map<String, String> f(String json) throws JSONException {
        JSONObject dataObj = new JSONObject(json);
        Map<String, String> keyData = new HashMap();
        Iterator<String> keyIter = dataObj.keys();
        while (keyIter.hasNext()) {
            String key = (String) keyIter.next();
            keyData.put(key, tn.a(dataObj, key));
        }
        return keyData;
    }

    private static String a(JSONObject json, String key) {
        return !json.isNull(key) ? json.optString(key, null) : null;
    }
}
