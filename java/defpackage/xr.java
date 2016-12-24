package defpackage;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class xr<O extends xf$a> {
    private final Context a;
    private final abm b;
    private final xf<O> c;
    private final O d;
    private final aba<O> e;
    private final int f;
    private final abg g;
    private final AtomicBoolean h;
    private final AtomicInteger i;

    public void a() {
        boolean z = true;
        if (!this.h.getAndSet(true)) {
            this.b.a();
            abg abg = this.g;
            int i = this.f;
            if (this.i.get() <= 0) {
                z = false;
            }
            abg.a(i, z);
        }
    }

    public xf<O> b() {
        return this.c;
    }

    public O c() {
        return this.d;
    }

    public aba<O> d() {
        return this.e;
    }

    public Context e() {
        return this.a;
    }
}
