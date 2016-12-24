package defpackage;

/* compiled from: WorkQueue */
class wh$1 implements Runnable {
    final /* synthetic */ wh$b a;
    final /* synthetic */ wh b;

    wh$1(wh this$0, wh$b wh_b) {
        this.b = this$0;
        this.a = wh_b;
    }

    public void run() {
        try {
            this.a.d().run();
        } finally {
            this.b.a(this.a);
        }
    }
}
