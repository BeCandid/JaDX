package defpackage;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class yq {
    private static final Object a = new Object();
    private static yq b;

    public static yq a(Context context) {
        synchronized (a) {
            if (b == null) {
                b = new yr(context.getApplicationContext());
            }
        }
        return b;
    }

    public abstract boolean a(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void b(String str, String str2, ServiceConnection serviceConnection, String str3);
}
