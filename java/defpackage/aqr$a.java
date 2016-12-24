package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: EventLoopsScheduler */
class aqr$a extends apo$a {
    private final aqz a = new aqz();
    private final asv b = new asv();
    private final aqz c = new aqz(this.a, this.b);
    private final aqr$c d;

    aqr$a(aqr$c poolWorker) {
        this.d = poolWorker;
    }

    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    public aps a(apy action) {
        if (isUnsubscribed()) {
            return asy.b();
        }
        return this.d.a(action, 0, null, this.a);
    }

    public aps a(apy action, long delayTime, TimeUnit unit) {
        if (isUnsubscribed()) {
            return asy.b();
        }
        return this.d.a(action, delayTime, unit, this.b);
    }
}
