package defpackage;

/* compiled from: Observable */
class apl$1 implements apm<T> {
    final /* synthetic */ apz a;
    final /* synthetic */ apl b;

    apl$1(apl apl, apz apz) {
        this.b = apl;
        this.a = apz;
    }

    public final void onCompleted() {
    }

    public final void onError(Throwable e) {
        this.a.call(e);
    }

    public final void onNext(T t) {
    }
}
