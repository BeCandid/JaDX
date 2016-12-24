package defpackage;

import java.util.concurrent.Executor;

/* compiled from: WorkQueue */
public class wh {
    static final /* synthetic */ boolean a = (!wh.class.desiredAssertionStatus());
    private final Object b;
    private wh$b c;
    private final int d;
    private final Executor e;
    private wh$b f;
    private int g;

    public wh() {
        this(8);
    }

    public wh(int maxConcurrent) {
        this(maxConcurrent, ul.d());
    }

    public wh(int maxConcurrent, Executor executor) {
        this.b = new Object();
        this.f = null;
        this.g = 0;
        this.d = maxConcurrent;
        this.e = executor;
    }

    public wh$a a(Runnable callback) {
        return a(callback, true);
    }

    public wh$a a(Runnable callback, boolean addToFront) {
        wh$b node = new wh$b(this, callback);
        synchronized (this.b) {
            this.c = node.a(this.c, addToFront);
        }
        a();
        return node;
    }

    private void a() {
        a(null);
    }

    private void a(wh$b finished) {
        wh$b ready = null;
        synchronized (this.b) {
            if (finished != null) {
                this.f = finished.a(this.f);
                this.g--;
            }
            if (this.g < this.d) {
                ready = this.c;
                if (ready != null) {
                    this.c = ready.a(this.c);
                    this.f = ready.a(this.f, false);
                    this.g++;
                    ready.a(true);
                }
            }
        }
        if (ready != null) {
            b(ready);
        }
    }

    private void b(wh$b node) {
        this.e.execute(new wh$1(this, node));
    }
}
