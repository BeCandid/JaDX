package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;

/* compiled from: CachedThreadScheduler */
public final class asm extends apo implements aqu {
    static final RxThreadFactory b = new RxThreadFactory("RxCachedThreadScheduler-");
    static final RxThreadFactory c = new RxThreadFactory("RxCachedWorkerPoolEvictor-");
    static final asm$c d = new asm$c(new RxThreadFactory("RxCachedThreadSchedulerShutdown-"));
    static final asm$a f = new asm$a(0, null);
    private static final TimeUnit g = TimeUnit.SECONDS;
    final AtomicReference<asm$a> e = new AtomicReference(f);

    static {
        d.unsubscribe();
        f.d();
    }

    public asm() {
        a();
    }

    public void a() {
        asm$a update = new asm$a(60, g);
        if (!this.e.compareAndSet(f, update)) {
            update.d();
        }
    }

    public void b() {
        asm$a curr;
        do {
            curr = (asm$a) this.e.get();
            if (curr == f) {
                return;
            }
        } while (!this.e.compareAndSet(curr, f));
        curr.d();
    }

    public apo$a createWorker() {
        return new asm$b((asm$a) this.e.get());
    }
}
