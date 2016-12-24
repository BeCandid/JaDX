package defpackage;

/* compiled from: OperatorSubscribeOn */
public final class aqp<T> implements apl$a<T> {
    final apo a;
    final apl<T> b;

    public /* synthetic */ void call(Object x0) {
        a((apr) x0);
    }

    public aqp(apl<T> source, apo scheduler) {
        this.a = scheduler;
        this.b = source;
    }

    public void a(apr<? super T> subscriber) {
        apo$a inner = this.a.createWorker();
        subscriber.add(inner);
        inner.a(new aqp$1(this, subscriber, inner));
    }
}
