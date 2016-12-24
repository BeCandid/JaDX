package defpackage;

/* compiled from: SerializedSubject */
public class ass<T, R> extends ast<T, R> {
    private final asf<T> c;
    private final ast<T, R> d;

    public ass(ast<T, R> actual) {
        super(new ass$1(actual));
        this.d = actual;
        this.c = new asf(actual);
    }

    public void onCompleted() {
        this.c.onCompleted();
    }

    public void onError(Throwable e) {
        this.c.onError(e);
    }

    public void onNext(T t) {
        this.c.onNext(t);
    }
}
