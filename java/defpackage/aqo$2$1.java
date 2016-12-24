package defpackage;

/* compiled from: OperatorOnErrorResumeNextViaFunction */
class aqo$2$1 extends apr<T> {
    final /* synthetic */ aqo$2 a;

    aqo$2$1(aqo$2 aqo_2) {
        this.a = aqo_2;
    }

    public void onNext(T t) {
        this.a.b.onNext(t);
    }

    public void onError(Throwable e) {
        this.a.b.onError(e);
    }

    public void onCompleted() {
        this.a.b.onCompleted();
    }

    public void setProducer(apn producer) {
        this.a.c.a(producer);
    }
}
