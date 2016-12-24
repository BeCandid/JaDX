package defpackage;

/* compiled from: OperatorFilter */
class aqk$1 extends apr<T> {
    final /* synthetic */ apr a;
    final /* synthetic */ aqk b;

    aqk$1(aqk aqk, apr x0, apr apr) {
        this.b = aqk;
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
        try {
            if (((Boolean) this.b.a.call(t)).booleanValue()) {
                this.a.onNext(t);
            } else {
                request(1);
            }
        } catch (Throwable e) {
            apx.a(e, this.a, t);
        }
    }
}
