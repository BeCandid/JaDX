package defpackage;

class agg$a$3 implements Runnable {
    final /* synthetic */ aha a;
    final /* synthetic */ agg$a b;

    agg$a$3(agg$a agg_a, aha aha) {
        this.b = agg_a;
        this.a = aha;
    }

    public void run() {
        synchronized (this.b) {
            this.b.b = false;
            if (!this.b.a.f()) {
                this.b.a.w().D().a("Connected to remote service");
                this.b.a.a(this.a);
            }
        }
    }
}
