package defpackage;

import io.fabric.sdk.android.services.concurrency.AsyncTask;
import io.fabric.sdk.android.services.concurrency.AsyncTask.Status;
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

/* compiled from: PriorityAsyncTask */
public abstract class ame<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements amc<amk>, amh, amk {
    private final ami a = new ami();

    public /* synthetic */ void c(Object x0) {
        a((amk) x0);
    }

    public final void a(ExecutorService exec, Params... params) {
        super.a(new ame$a(exec, this), params);
    }

    public int compareTo(Object another) {
        return Priority.a(this, another);
    }

    public void a(amk task) {
        if (d_() != Status.a) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((amc) ((amh) g())).c(task);
    }

    public Collection<amk> c() {
        return ((amc) ((amh) g())).c();
    }

    public boolean d() {
        return ((amc) ((amh) g())).d();
    }

    public Priority b() {
        return ((amh) g()).b();
    }

    public void b(boolean finished) {
        ((amk) ((amh) g())).b(finished);
    }

    public boolean f() {
        return ((amk) ((amh) g())).f();
    }

    public void a(Throwable throwable) {
        ((amk) ((amh) g())).a(throwable);
    }

    public <T extends amc<amk> & amh & amk> T g() {
        return this.a;
    }
}
