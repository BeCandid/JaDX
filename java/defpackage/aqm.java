package defpackage;

import rx.schedulers.ImmediateScheduler;

/* compiled from: OperatorObserveOn */
public final class aqm<T> implements apl$b<T, T> {
    private final apo a;
    private final boolean b;

    public /* synthetic */ Object call(Object x0) {
        return a((apr) x0);
    }

    public aqm(apo scheduler, boolean delayError) {
        this.a = scheduler;
        this.b = delayError;
    }

    public apr<? super T> a(apr<? super T> child) {
        if ((this.a instanceof ImmediateScheduler) || (this.a instanceof asq)) {
            return child;
        }
        apr parent = new aqm$a(this.a, child, this.b);
        parent.a();
        return parent;
    }
}
