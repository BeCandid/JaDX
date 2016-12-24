package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker */
public class pt {
    private final Set<qd> a = Collections.newSetFromMap(new WeakHashMap());
    private final List<qd> b = new ArrayList();
    private boolean c;

    public void a(qd request) {
        this.a.add(request);
        if (this.c) {
            this.b.add(request);
        } else {
            request.b();
        }
    }

    public void b(qd request) {
        this.a.remove(request);
        this.b.remove(request);
    }

    public void a() {
        this.c = true;
        for (qd request : ri.a(this.a)) {
            if (request.f()) {
                request.e();
                this.b.add(request);
            }
        }
    }

    public void b() {
        this.c = false;
        for (qd request : ri.a(this.a)) {
            if (!(request.g() || request.i() || request.f())) {
                request.b();
            }
        }
        this.b.clear();
    }

    public void c() {
        for (qd request : ri.a(this.a)) {
            request.d();
        }
        this.b.clear();
    }

    public void d() {
        for (qd request : ri.a(this.a)) {
            if (!(request.g() || request.i())) {
                request.e();
                if (this.c) {
                    this.b.add(request);
                } else {
                    request.b();
                }
            }
        }
    }
}
