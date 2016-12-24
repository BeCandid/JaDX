package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CachedThreadScheduler */
final class asm$b extends apo$a {
    static final AtomicIntegerFieldUpdater<asm$b> b = AtomicIntegerFieldUpdater.newUpdater(asm$b.class, "a");
    volatile int a;
    private final asv c = new asv();
    private final asm$a d;
    private final asm$c e;

    asm$b(asm$a pool) {
        this.d = pool;
        this.e = pool.a();
    }

    public void unsubscribe() {
        if (b.compareAndSet(this, 0, 1)) {
            this.d.a(this.e);
        }
        this.c.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    public aps a(apy action) {
        return a(action, 0, null);
    }

    public aps a(apy action, long delayTime, TimeUnit unit) {
        if (this.c.isUnsubscribed()) {
            return asy.b();
        }
        aps s = this.e.b(action, delayTime, unit);
        this.c.a(s);
        s.a(this.c);
        return s;
    }
}
