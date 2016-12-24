package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONObject;

/* compiled from: Utility */
class we$1 implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    we$1(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    public void run() {
        SharedPreferences sharedPrefs = this.a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        String settingsJSONString = sharedPrefs.getString(this.b, null);
        if (!we.a(settingsJSONString)) {
            JSONObject settingsJSON = null;
            try {
                settingsJSON = new JSONObject(settingsJSONString);
            } catch (Exception je) {
                we.a("FacebookSDK", je);
            }
            if (settingsJSON != null) {
                we.b(this.c, settingsJSON);
            }
        }
        JSONObject resultJSON = we.g(this.c);
        if (resultJSON != null) {
            we.b(this.c, resultJSON);
            sharedPrefs.edit().putString(this.b, resultJSON.toString()).apply();
        }
        we.c.set(false);
    }
}
