package defpackage;

import android.os.Handler;

abstract class agt {
    private static volatile Handler b;
    private final ahk a;
    private final Runnable c = new agt$1(this);
    private volatile long d;
    private boolean e = true;

    agt(ahk ahk) {
        xz.a((Object) ahk);
        this.a = ahk;
    }

    private Handler d() {
        if (b != null) {
            return b;
        }
        Handler handler;
        synchronized (agt.class) {
            if (b == null) {
                b = new Handler(this.a.q().getMainLooper());
            }
            handler = b;
        }
        return handler;
    }

    public abstract void a();

    public void a(long j) {
        c();
        if (j >= 0) {
            this.d = this.a.r().a();
            if (!d().postDelayed(this.c, j)) {
                this.a.f().f().a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public boolean b() {
        return this.d != 0;
    }

    public void c() {
        this.d = 0;
        d().removeCallbacks(this.c);
    }
}
