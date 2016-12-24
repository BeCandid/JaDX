package defpackage;

/* compiled from: OperatorMap */
class aql$1 extends apr<T> {
    final /* synthetic */ apr a;
    final /* synthetic */ aql b;

    aql$1(aql aql, apr x0, apr apr) {
        this.b = aql;
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
            this.a.onNext(this.b.a.call(t));
        } catch (Throwable e) {
            apx.a(e, this, t);
        }
    }
}
