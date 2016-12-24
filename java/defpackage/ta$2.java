package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsExecutorServiceWrapper */
class ta$2 implements Callable<T> {
    final /* synthetic */ Callable a;
    final /* synthetic */ ta b;

    ta$2(ta taVar, Callable callable) {
        this.b = taVar;
        this.a = callable;
    }

    public T call() throws Exception {
        try {
            return this.a.call();
        } catch (Exception e) {
            akx.h().e("CrashlyticsCore", "Failed to execute task.", e);
            return null;
        }
    }
}
