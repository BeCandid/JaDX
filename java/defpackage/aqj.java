package defpackage;

/* compiled from: OperatorDoOnEach */
public class aqj<T> implements apl$b<T, T> {
    final apm<? super T> a;

    public /* synthetic */ Object call(Object x0) {
        return a((apr) x0);
    }

    public aqj(apm<? super T> doOnEachObserver) {
        this.a = doOnEachObserver;
    }

    public apr<? super T> a(apr<? super T> observer) {
        return new aqj$1(this, observer, observer);
    }
}
