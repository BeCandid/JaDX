package defpackage;

import android.content.Context;

/* compiled from: LoginManager */
class wm$c {
    private static volatile wl a;

    private static synchronized wl b(Context context) {
        wl wlVar;
        synchronized (wm$c.class) {
            if (context == null) {
                context = ul.f();
            }
            if (context == null) {
                wlVar = null;
            } else {
                if (a == null) {
                    a = new wl(context, ul.i());
                }
                wlVar = a;
            }
        }
        return wlVar;
    }
}
