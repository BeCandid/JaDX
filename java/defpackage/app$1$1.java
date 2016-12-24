package defpackage;

import rx.internal.producers.SingleDelayedProducer;

/* compiled from: Single */
class app$1$1 extends apq<T> {
    final /* synthetic */ SingleDelayedProducer a;
    final /* synthetic */ apr b;
    final /* synthetic */ app$1 c;

    app$1$1(app$1 app_1, SingleDelayedProducer singleDelayedProducer, apr apr) {
        this.c = app_1;
        this.a = singleDelayedProducer;
        this.b = apr;
    }

    public void a(T value) {
        this.a.a(value);
    }

    public void a(Throwable error) {
        this.b.onError(error);
    }
}
