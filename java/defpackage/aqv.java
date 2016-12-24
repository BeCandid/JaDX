package defpackage;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.schedulers.Schedulers;

/* compiled from: ObjectPool */
public abstract class aqv<T> implements aqu {
    Queue<T> a;
    final int b;
    final int c;
    private final long d;
    private final AtomicReference<apo$a> e;

    protected abstract T d();

    public aqv() {
        this(0, 0, 67);
    }

    private aqv(int min, int max, long validationInterval) {
        this.b = min;
        this.c = max;
        this.d = validationInterval;
        this.e = new AtomicReference();
        a(min);
        c();
    }

    public T a() {
        T object = this.a.poll();
        if (object == null) {
            return d();
        }
        return object;
    }

    public void a(T object) {
        if (object != null) {
            this.a.offer(object);
        }
    }

    public void b() {
        apo$a w = (apo$a) this.e.getAndSet(null);
        if (w != null) {
            w.unsubscribe();
        }
    }

    public void c() {
        apo$a w = Schedulers.computation().createWorker();
        if (this.e.compareAndSet(null, w)) {
            w.a(new aqv$1(this), this.d, this.d, TimeUnit.SECONDS);
        } else {
            w.unsubscribe();
        }
    }

    private void a(int min) {
        if (asd.a()) {
            this.a = new ari(Math.max(this.c, 1024));
        } else {
            this.a = new ConcurrentLinkedQueue();
        }
        for (int i = 0; i < min; i++) {
            this.a.add(d());
        }
    }
}
