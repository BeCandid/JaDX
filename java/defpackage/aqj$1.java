package defpackage;

import java.util.Arrays;
import rx.exceptions.CompositeException;

/* compiled from: OperatorDoOnEach */
class aqj$1 extends apr<T> {
    final /* synthetic */ apr a;
    final /* synthetic */ aqj b;
    private boolean c = false;

    aqj$1(aqj aqj, apr x0, apr apr) {
        this.b = aqj;
        this.a = apr;
        super(x0);
    }

    public void onCompleted() {
        if (!this.c) {
            try {
                this.b.a.onCompleted();
                this.c = true;
                this.a.onCompleted();
            } catch (Throwable e) {
                apx.a(e, (apm) this);
            }
        }
    }

    public void onError(Throwable e) {
        apx.a(e);
        if (!this.c) {
            this.c = true;
            try {
                this.b.a.onError(e);
                this.a.onError(e);
            } catch (Throwable e2) {
                apx.a(e2);
                this.a.onError(new CompositeException(Arrays.asList(new Throwable[]{e, e2})));
            }
        }
    }

    public void onNext(T value) {
        if (!this.c) {
            try {
                this.b.a.onNext(value);
                this.a.onNext(value);
            } catch (Throwable e) {
                apx.a(e, this, value);
            }
        }
    }
}
