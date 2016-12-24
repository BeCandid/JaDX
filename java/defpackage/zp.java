package defpackage;

import android.os.SystemClock;

public final class zp implements zn {
    private static zp a;

    public static synchronized zn d() {
        zn znVar;
        synchronized (zp.class) {
            if (a == null) {
                a = new zp();
            }
            znVar = a;
        }
        return znVar;
    }

    public long a() {
        return System.currentTimeMillis();
    }

    public long b() {
        return SystemClock.elapsedRealtime();
    }

    public long c() {
        return System.nanoTime();
    }
}
