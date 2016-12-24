package defpackage;

import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: PriorityFutureTask */
public class amg<V> extends FutureTask<V> implements amc<amk>, amh, amk {
    final Object b;

    public /* synthetic */ void c(Object x0) {
        a((amk) x0);
    }

    public amg(Callable<V> callable) {
        super(callable);
        this.b = a((Object) callable);
    }

    public amg(Runnable runnable, V result) {
        super(runnable, result);
        this.b = a((Object) runnable);
    }

    public int compareTo(Object another) {
        return ((amh) a()).compareTo(another);
    }

    public void a(amk task) {
        ((amc) ((amh) a())).c(task);
    }

    public Collection<amk> c() {
        return ((amc) ((amh) a())).c();
    }

    public boolean d() {
        return ((amc) ((amh) a())).d();
    }

    public Priority b() {
        return ((amh) a()).b();
    }

    public void b(boolean finished) {
        ((amk) ((amh) a())).b(finished);
    }

    public boolean f() {
        return ((amk) ((amh) a())).f();
    }

    public void a(Throwable throwable) {
        ((amk) ((amh) a())).a(throwable);
    }

    public <T extends amc<amk> & amh & amk> T a() {
        return (amc) this.b;
    }

    protected <T extends amc<amk> & amh & amk> T a(Object object) {
        if (ami.a(object)) {
            return (amc) object;
        }
        return new ami();
    }
}
