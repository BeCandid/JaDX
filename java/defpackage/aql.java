package defpackage;

/* compiled from: OperatorMap */
public final class aql<T, R> implements apl$b<R, T> {
    final aqc<? super T, ? extends R> a;

    public /* synthetic */ Object call(Object x0) {
        return a((apr) x0);
    }

    public aql(aqc<? super T, ? extends R> transformer) {
        this.a = transformer;
    }

    public apr<? super T> a(apr<? super R> o) {
        return new aql$1(this, o, o);
    }
}
