package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.EngineRunnable;
import com.bumptech.glide.load.engine.EngineRunnable.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: EngineJob */
class ld implements a {
    private static final ld$a a = new ld$a();
    private static final Handler b = new Handler(Looper.getMainLooper(), new ld$b(null));
    private final List<qg> c;
    private final ld$a d;
    private final le e;
    private final kn f;
    private final ExecutorService g;
    private final ExecutorService h;
    private final boolean i;
    private boolean j;
    private lj<?> k;
    private boolean l;
    private Exception m;
    private boolean n;
    private Set<qg> o;
    private EngineRunnable p;
    private lh<?> q;
    private volatile Future<?> r;

    public ld(kn key, ExecutorService diskCacheService, ExecutorService sourceService, boolean isCacheable, le listener) {
        this(key, diskCacheService, sourceService, isCacheable, listener, a);
    }

    public ld(kn key, ExecutorService diskCacheService, ExecutorService sourceService, boolean isCacheable, le listener, ld$a engineResourceFactory) {
        this.c = new ArrayList();
        this.f = key;
        this.g = diskCacheService;
        this.h = sourceService;
        this.i = isCacheable;
        this.e = listener;
        this.d = engineResourceFactory;
    }

    public void a(EngineRunnable engineRunnable) {
        this.p = engineRunnable;
        this.r = this.g.submit(engineRunnable);
    }

    public void b(EngineRunnable runnable) {
        this.r = this.h.submit(runnable);
    }

    public void a(qg cb) {
        ri.a();
        if (this.l) {
            cb.a(this.q);
        } else if (this.n) {
            cb.a(this.m);
        } else {
            this.c.add(cb);
        }
    }

    public void b(qg cb) {
        ri.a();
        if (this.l || this.n) {
            c(cb);
            return;
        }
        this.c.remove(cb);
        if (this.c.isEmpty()) {
            a();
        }
    }

    private void c(qg cb) {
        if (this.o == null) {
            this.o = new HashSet();
        }
        this.o.add(cb);
    }

    private boolean d(qg cb) {
        return this.o != null && this.o.contains(cb);
    }

    void a() {
        if (!this.n && !this.l && !this.j) {
            this.p.a();
            Future currentFuture = this.r;
            if (currentFuture != null) {
                currentFuture.cancel(true);
            }
            this.j = true;
            this.e.a(this, this.f);
        }
    }

    public void a(lj<?> resource) {
        this.k = resource;
        b.obtainMessage(1, this).sendToTarget();
    }

    private void b() {
        if (this.j) {
            this.k.d();
        } else if (this.c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else {
            this.q = this.d.a(this.k, this.i);
            this.l = true;
            this.q.e();
            this.e.a(this.f, this.q);
            for (qg cb : this.c) {
                if (!d(cb)) {
                    this.q.e();
                    cb.a(this.q);
                }
            }
            this.q.f();
        }
    }

    public void a(Exception e) {
        this.m = e;
        b.obtainMessage(2, this).sendToTarget();
    }

    private void c() {
        if (!this.j) {
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            this.n = true;
            this.e.a(this.f, null);
            for (qg cb : this.c) {
                if (!d(cb)) {
                    cb.a(this.m);
                }
            }
        }
    }
}
