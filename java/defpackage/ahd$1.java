package defpackage;

class ahd$1 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ahd b;

    ahd$1(ahd ahd, String str) {
        this.b = ahd;
        this.a = str;
    }

    public void run() {
        ahh e = this.b.n.e();
        if (!e.a() || e.b()) {
            this.b.a(6, "Persisted config not initialized . Not logging error/warn.");
        } else {
            e.b.a(this.a);
        }
    }
}
