package defpackage;

import rx.internal.producers.SingleDelayedProducer;

/* compiled from: Single */
class app$1 implements apl$a<T> {
    final /* synthetic */ app$a a;
    final /* synthetic */ app b;

    app$1(app app, app$a app_a) {
        this.b = app;
        this.a = app_a;
    }

    public /* synthetic */ void call(Object x0) {
        a((apr) x0);
    }

    public void a(apr<? super T> child) {
        SingleDelayedProducer<T> producer = new SingleDelayedProducer(child);
        child.setProducer(producer);
        apq<T> ss = new app$1$1(this, producer, child);
        child.add(ss);
        this.a.call(ss);
    }
}
