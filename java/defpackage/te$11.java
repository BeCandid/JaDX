package defpackage;

import java.util.Date;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class te$11 implements Runnable {
    final /* synthetic */ Date a;
    final /* synthetic */ Thread b;
    final /* synthetic */ Throwable c;
    final /* synthetic */ te d;

    te$11(te teVar, Date date, Thread thread, Throwable th) {
        this.d = teVar;
        this.a = date;
        this.b = thread;
        this.c = th;
    }

    public void run() {
        if (!this.d.k.get()) {
            this.d.c(this.a, this.b, this.c);
        }
    }
}
