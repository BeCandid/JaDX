package defpackage;

/* compiled from: Observer */
public interface apm<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
