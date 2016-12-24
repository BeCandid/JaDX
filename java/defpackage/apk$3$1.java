package defpackage;

/* compiled from: Completable */
class apk$3$1 implements apy {
    final /* synthetic */ apk$b a;
    final /* synthetic */ apo$a b;
    final /* synthetic */ apk$3 c;

    apk$3$1(apk$3 apk_3, apk$b apk_b, apo$a apo_a) {
        this.c = apk_3;
        this.a = apk_b;
        this.b = apo_a;
    }

    public void call() {
        try {
            this.c.b.a(this.a);
        } finally {
            this.b.unsubscribe();
        }
    }
}
