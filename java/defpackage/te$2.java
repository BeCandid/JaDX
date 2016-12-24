package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class te$2 implements Callable<Void> {
    final /* synthetic */ te a;

    te$2(te teVar) {
        this.a = teVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        this.a.l();
        return null;
    }
}
