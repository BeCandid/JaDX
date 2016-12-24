package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler */
public abstract class apo {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public abstract apo$a createWorker();

    public long now() {
        return System.currentTimeMillis();
    }
}
