package defpackage;

/* compiled from: OnSubscribeSingle */
public class aqh<T> implements app$a<T> {
    private final apl<T> a;

    public /* synthetic */ void call(Object x0) {
        a((apq) x0);
    }

    public aqh(apl<T> observable) {
        this.a = observable;
    }

    public void a(apq<? super T> child) {
        apr parent = new aqh$1(this, child);
        child.a((aps) parent);
        this.a.a(parent);
    }

    public static <T> aqh<T> a(apl<T> observable) {
        return new aqh(observable);
    }
}
