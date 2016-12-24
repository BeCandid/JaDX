package defpackage;

/* compiled from: OperatorFilter */
public final class aqk<T> implements apl$b<T, T> {
    final aqc<? super T, Boolean> a;

    public /* synthetic */ Object call(Object x0) {
        return a((apr) x0);
    }

    public aqk(aqc<? super T, Boolean> predicate) {
        this.a = predicate;
    }

    public apr<? super T> a(apr<? super T> child) {
        return new aqk$1(this, child, child);
    }
}
