package defpackage;

/* compiled from: Completable */
class apk$3 implements apk$a {
    final /* synthetic */ apo a;
    final /* synthetic */ apk b;

    apk$3(apk apk, apo apo) {
        this.b = apk;
        this.a = apo;
    }

    public /* synthetic */ void call(Object x0) {
        a((apk$b) x0);
    }

    public void a(apk$b s) {
        apo$a w = this.a.createWorker();
        w.a(new apk$3$1(this, s, w));
    }
}
