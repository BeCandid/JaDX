package defpackage;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.File;
import java.util.Collection;

/* compiled from: Kit */
public abstract class alc<Result> implements Comparable<alc> {
    akx e;
    alb<Result> f = new alb(this);
    Context g;
    ala<Result> h;
    IdManager i;
    final amd j = ((amd) getClass().getAnnotation(amd.class));

    public abstract String a();

    public abstract String b();

    protected abstract Result f();

    public /* synthetic */ int compareTo(Object x0) {
        return a((alc) x0);
    }

    void a(Context context, akx fabric, ala<Result> callback, IdManager idManager) {
        this.e = fabric;
        this.g = new aky(context, b(), G());
        this.h = callback;
        this.i = idManager;
    }

    final void C() {
        this.f.a(this.e.f(), (Void) null);
    }

    protected boolean a_() {
        return true;
    }

    protected void a(Result result) {
    }

    protected void b(Result result) {
    }

    protected IdManager D() {
        return this.i;
    }

    public Context E() {
        return this.g;
    }

    public akx F() {
        return this.e;
    }

    public String G() {
        return ".Fabric" + File.separator + b();
    }

    public int a(alc another) {
        if (b(another)) {
            return 1;
        }
        if (another.b(this)) {
            return -1;
        }
        if (H() && !another.H()) {
            return 1;
        }
        if (H() || !another.H()) {
            return 0;
        }
        return -1;
    }

    boolean b(alc target) {
        if (H()) {
            for (Class<?> dep : this.j.a()) {
                if (dep.isAssignableFrom(target.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean H() {
        return this.j != null;
    }

    protected Collection<amk> I() {
        return this.f.c();
    }
}
