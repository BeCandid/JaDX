package defpackage;

/* compiled from: Subscribers */
class asg$1 extends apr<T> {
    final /* synthetic */ apr a;

    asg$1(apr x0, apr apr) {
        this.a = apr;
        super(x0);
    }

    public void onCompleted() {
        this.a.onCompleted();
    }

    public void onError(Throwable e) {
        this.a.onError(e);
    }

    public void onNext(T t) {
        this.a.onNext(t);
    }
}
