package defpackage;

/* compiled from: Observable */
class apl$c$1 implements apl$a<T> {
    final /* synthetic */ Throwable a;

    apl$c$1(Throwable th) {
        this.a = th;
    }

    public /* synthetic */ void call(Object x0) {
        a((apr) x0);
    }

    public void a(apr<? super T> observer) {
        observer.onError(this.a);
    }
}
