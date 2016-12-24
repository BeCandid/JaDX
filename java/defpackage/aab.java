package defpackage;

import android.content.Context;
import android.util.Log;

class aab {
    private static Context a;

    static synchronized void a(Context context) {
        synchronized (aab.class) {
            if (a != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                a = context.getApplicationContext();
            }
        }
    }
}
