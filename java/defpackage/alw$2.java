package defpackage;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorUtils */
class alw$2 extends als {
    final /* synthetic */ String a;
    final /* synthetic */ ExecutorService b;
    final /* synthetic */ long c;
    final /* synthetic */ TimeUnit d;

    alw$2(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.a = str;
        this.b = executorService;
        this.c = j;
        this.d = timeUnit;
    }

    public void a() {
        try {
            akx.h().a("Fabric", "Executing shutdown hook for " + this.a);
            this.b.shutdown();
            if (!this.b.awaitTermination(this.c, this.d)) {
                akx.h().a("Fabric", this.a + " did not shut down in the" + " allocated time. Requesting immediate shutdown.");
                this.b.shutdownNow();
            }
        } catch (InterruptedException e) {
            akx.h().a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.a}));
            this.b.shutdownNow();
        }
    }
}
