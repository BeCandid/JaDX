package defpackage;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;

/* compiled from: ExecutorScheduler */
final class asn$a extends apo$a implements Runnable {
    final Executor a;
    final asv b = new asv();
    final ConcurrentLinkedQueue<ScheduledAction> c = new ConcurrentLinkedQueue();
    final AtomicInteger d = new AtomicInteger();

    public asn$a(Executor executor) {
        this.a = executor;
    }

    public aps a(apy action) {
        if (isUnsubscribed()) {
            return asy.b();
        }
        aps ea = new ScheduledAction(action, this.b);
        this.b.a(ea);
        this.c.offer(ea);
        if (this.d.getAndIncrement() != 0) {
            return ea;
        }
        try {
            this.a.execute(this);
            return ea;
        } catch (Throwable t) {
            this.b.b(ea);
            this.d.decrementAndGet();
            ask.a().b().a(t);
            throw t;
        }
    }

    public void run() {
        do {
            ScheduledAction sa = (ScheduledAction) this.c.poll();
            if (!sa.isUnsubscribed()) {
                sa.run();
            }
        } while (this.d.decrementAndGet() > 0);
    }

    public aps a(apy action, long delayTime, TimeUnit unit) {
        if (delayTime <= 0) {
            return a(action);
        }
        if (isUnsubscribed()) {
            return asy.b();
        }
        ScheduledExecutorService service;
        if (this.a instanceof ScheduledExecutorService) {
            service = this.a;
        } else {
            service = aqs.c();
        }
        asw first = new asw();
        aps mas = new asw();
        mas.a(first);
        this.b.a(mas);
        aps removeMas = asy.a(new asn$a$1(this, mas));
        ScheduledAction ea = new ScheduledAction(new asn$a$2(this, mas, action, removeMas));
        first.a(ea);
        try {
            ea.a(service.schedule(ea, delayTime, unit));
            return removeMas;
        } catch (Throwable t) {
            ask.a().b().a(t);
            throw t;
        }
    }

    public boolean isUnsubscribed() {
        return this.b.isUnsubscribed();
    }

    public void unsubscribe() {
        this.b.unsubscribe();
    }
}
