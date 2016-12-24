package defpackage;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

public class abp<R extends xk> extends xo<R> implements xl<R> {
    private xn<? super R, ? extends xk> a;
    private abp<? extends xk> b;
    private volatile xm<? super R> c;
    private xi<R> d;
    private final Object e;
    private Status f;
    private final WeakReference<xh> g;
    private final abp$a h;
    private boolean i;

    private void a() {
        if (this.a != null || this.c != null) {
            xh xhVar = (xh) this.g.get();
            if (!(this.i || this.a == null || xhVar == null)) {
                xhVar.a(this);
                this.i = true;
            }
            if (this.f != null) {
                b(this.f);
            } else if (this.d != null) {
                this.d.a(this);
            }
        }
    }

    private void a(Status status) {
        synchronized (this.e) {
            this.f = status;
            b(this.f);
        }
    }

    private void b(Status status) {
        synchronized (this.e) {
            if (this.a != null) {
                Status a = this.a.a(status);
                xz.a((Object) a, (Object) "onFailure must not return null");
                this.b.a(a);
            } else if (b()) {
                this.c.a(status);
            }
        }
    }

    private void b(xk xkVar) {
        if (xkVar instanceof xj) {
            try {
                ((xj) xkVar).a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(xkVar);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private boolean b() {
        return (this.c == null || ((xh) this.g.get()) == null) ? false : true;
    }

    public void a(xi<?> xiVar) {
        synchronized (this.e) {
            this.d = xiVar;
            a();
        }
    }

    public void a(R r) {
        synchronized (this.e) {
            if (!r.a().f()) {
                a(r.a());
                b((xk) r);
            } else if (this.a != null) {
                abn.a().submit(new abp$1(this, r));
            } else if (b()) {
                this.c.b(r);
            }
        }
    }
}
