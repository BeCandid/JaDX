package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class te$10 implements Callable<Void> {
    final /* synthetic */ long a;
    final /* synthetic */ String b;
    final /* synthetic */ te c;

    te$10(te teVar, long j, String str) {
        this.c = teVar;
        this.a = j;
        this.b = str;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        if (!this.c.k.get()) {
            this.c.o.a(this.a, this.b);
        }
        return null;
    }
}
