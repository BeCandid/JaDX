package defpackage;

import java.util.concurrent.Executor;

/* compiled from: ExecutorScheduler */
public final class asn extends apo {
    final Executor b;

    public asn(Executor executor) {
        this.b = executor;
    }

    public apo$a createWorker() {
        return new asn$a(this.b);
    }
}
