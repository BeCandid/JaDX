package defpackage;

import android.os.Looper;

class agt$1 implements Runnable {
    final /* synthetic */ agt a;

    agt$1(agt agt) {
        this.a = agt;
    }

    public void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.a.a.h().a(this);
            return;
        }
        boolean b = this.a.b();
        this.a.d = 0;
        if (b && this.a.e) {
            this.a.a();
        }
    }
}
