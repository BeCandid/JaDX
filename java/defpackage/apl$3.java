package defpackage;

import rx.exceptions.OnErrorNotImplementedException;

/* compiled from: Observable */
class apl$3 extends apr<T> {
    final /* synthetic */ apz a;
    final /* synthetic */ apl b;

    apl$3(apl apl, apz apz) {
        this.b = apl;
        this.a = apz;
    }

    public final void onCompleted() {
    }

    public final void onError(Throwable e) {
        throw new OnErrorNotImplementedException(e);
    }

    public final void onNext(T args) {
        this.a.call(args);
    }
}
