package defpackage;

import java.util.NoSuchElementException;

/* compiled from: OnSubscribeSingle */
class aqh$1 extends apr<T> {
    final /* synthetic */ apq a;
    final /* synthetic */ aqh b;
    private boolean c = false;
    private boolean d = false;
    private T e = null;

    aqh$1(aqh aqh, apq apq) {
        this.b = aqh;
        this.a = apq;
    }

    public void onStart() {
        request(2);
    }

    public void onCompleted() {
        if (!this.c) {
            if (this.d) {
                this.a.a(this.e);
            } else {
                this.a.a(new NoSuchElementException("Observable emitted no items"));
            }
        }
    }

    public void onError(Throwable e) {
        this.a.a(e);
        unsubscribe();
    }

    public void onNext(T t) {
        if (this.d) {
            this.c = true;
            this.a.a(new IllegalArgumentException("Observable emitted too many elements"));
            unsubscribe();
            return;
        }
        this.d = true;
        this.e = t;
    }
}
