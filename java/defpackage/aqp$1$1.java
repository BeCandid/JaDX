package defpackage;

/* compiled from: OperatorSubscribeOn */
class aqp$1$1 extends apr<T> {
    final /* synthetic */ Thread a;
    final /* synthetic */ aqp$1 b;

    aqp$1$1(aqp$1 aqp_1, apr x0, Thread thread) {
        this.b = aqp_1;
        this.a = thread;
        super(x0);
    }

    public void onNext(T t) {
        this.b.a.onNext(t);
    }

    public void onError(Throwable e) {
        try {
            this.b.a.onError(e);
        } finally {
            this.b.b.unsubscribe();
        }
    }

    public void onCompleted() {
        try {
            this.b.a.onCompleted();
        } finally {
            this.b.b.unsubscribe();
        }
    }

    public void setProducer(apn p) {
        this.b.a.setProducer(new aqp$1$1$1(this, p));
    }
}
