package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;

/* compiled from: EventLoopsScheduler */
public class aqr extends apo implements aqu {
    static final RxThreadFactory b = new RxThreadFactory("RxComputationThreadPool-");
    static final int c;
    static final aqr$c d = new aqr$c(new RxThreadFactory("RxComputationShutdown-"));
    static final aqr$b e = new aqr$b(0);
    final AtomicReference<aqr$b> f = new AtomicReference(e);

    static {
        int max;
        int maxThreads = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int ncpu = Runtime.getRuntime().availableProcessors();
        if (maxThreads <= 0 || maxThreads > ncpu) {
            max = ncpu;
        } else {
            max = maxThreads;
        }
        c = max;
        d.unsubscribe();
    }

    public aqr() {
        a();
    }

    public apo$a createWorker() {
        return new aqr$a(((aqr$b) this.f.get()).a());
    }

    public void a() {
        aqr$b update = new aqr$b(c);
        if (!this.f.compareAndSet(e, update)) {
            update.b();
        }
    }

    public void b() {
        aqr$b curr;
        do {
            curr = (aqr$b) this.f.get();
            if (curr == e) {
                return;
            }
        } while (!this.f.compareAndSet(curr, e));
        curr.b();
    }

    public aps a(apy action) {
        return ((aqr$b) this.f.get()).a().b(action, -1, TimeUnit.NANOSECONDS);
    }
}
