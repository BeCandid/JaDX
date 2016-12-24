package defpackage;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler */
class asq$a extends apo$a implements aps {
    final AtomicInteger a = new AtomicInteger();
    final PriorityBlockingQueue<asq$b> b = new PriorityBlockingQueue();
    private final asu c = new asu();
    private final AtomicInteger d = new AtomicInteger();

    asq$a() {
    }

    public aps a(apy action) {
        return a(action, a());
    }

    public aps a(apy action, long delayTime, TimeUnit unit) {
        long execTime = a() + unit.toMillis(delayTime);
        return a(new asp(action, this, execTime), execTime);
    }

    private aps a(apy action, long execTime) {
        if (this.c.isUnsubscribed()) {
            return asy.b();
        }
        asq$b timedAction = new asq$b(action, Long.valueOf(execTime), this.a.incrementAndGet());
        this.b.add(timedAction);
        if (this.d.getAndIncrement() != 0) {
            return asy.a(new asq$a$1(this, timedAction));
        }
        do {
            asq$b polled = (asq$b) this.b.poll();
            if (polled != null) {
                polled.a.call();
            }
        } while (this.d.decrementAndGet() > 0);
        return asy.b();
    }

    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }
}
