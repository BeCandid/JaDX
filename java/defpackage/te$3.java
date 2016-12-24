package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class te$3 implements Callable<Boolean> {
    final /* synthetic */ te a;

    te$3(te teVar) {
        this.a = teVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Boolean a() throws Exception {
        if (this.a.k.get()) {
            akx.h().a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
            return Boolean.FALSE;
        }
        akx.h().a("CrashlyticsCore", "Finalizing previously open sessions.");
        ud crashEventData = this.a.n.v();
        if (crashEventData != null) {
            this.a.a(crashEventData);
        }
        this.a.a(true);
        akx.h().a("CrashlyticsCore", "Closed all previously open sessions");
        return Boolean.TRUE;
    }
}
