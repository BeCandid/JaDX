package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler */
public abstract class apo$a implements aps {
    public abstract aps a(apy apy);

    public abstract aps a(apy apy, long j, TimeUnit timeUnit);

    public aps a(apy action, long initialDelay, long period, TimeUnit unit) {
        long periodInNanos = unit.toNanos(period);
        long firstNowNanos = TimeUnit.MILLISECONDS.toNanos(a());
        long firstStartInNanos = firstNowNanos + unit.toNanos(initialDelay);
        asw mas = new asw();
        apy recursiveAction = new apo$a$1(this, firstNowNanos, firstStartInNanos, mas, action, periodInNanos);
        asw s = new asw();
        mas.a(s);
        s.a(a(recursiveAction, initialDelay, unit));
        return mas;
    }

    public long a() {
        return System.currentTimeMillis();
    }
}
