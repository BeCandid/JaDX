package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: OnSubscribeTimerOnce */
public final class aqi implements apl$a<Long> {
    final long a;
    final TimeUnit b;
    final apo c;

    public /* synthetic */ void call(Object x0) {
        a((apr) x0);
    }

    public aqi(long time, TimeUnit unit, apo scheduler) {
        this.a = time;
        this.b = unit;
        this.c = scheduler;
    }

    public void a(apr<? super Long> child) {
        apo$a worker = this.c.createWorker();
        child.add(worker);
        worker.a(new aqi$1(this, child), this.a, this.b);
    }
}
