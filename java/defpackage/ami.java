package defpackage;

import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PriorityTask */
public class ami implements amc<amk>, amh, amk {
    private final List<amk> a = new ArrayList();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicReference<Throwable> c = new AtomicReference(null);

    public /* synthetic */ void c(Object x0) {
        a((amk) x0);
    }

    public synchronized Collection<amk> c() {
        return Collections.unmodifiableCollection(this.a);
    }

    public synchronized void a(amk task) {
        this.a.add(task);
    }

    public boolean d() {
        for (amk task : c()) {
            if (!task.f()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void b(boolean finished) {
        this.b.set(finished);
    }

    public boolean f() {
        return this.b.get();
    }

    public Priority b() {
        return Priority.b;
    }

    public void a(Throwable throwable) {
        this.c.set(throwable);
    }

    public int compareTo(Object other) {
        return Priority.a(this, other);
    }

    public static boolean a(Object object) {
        try {
            amk task = (amk) object;
            amh provider = (amh) object;
            if (((amc) object) == null || task == null || provider == null) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
