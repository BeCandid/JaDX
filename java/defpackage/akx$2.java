package defpackage;

import java.util.concurrent.CountDownLatch;

/* compiled from: Fabric */
class akx$2 implements ala {
    final CountDownLatch a = new CountDownLatch(this.b);
    final /* synthetic */ int b;
    final /* synthetic */ akx c;

    akx$2(akx akx, int i) {
        this.c = akx;
        this.b = i;
    }

    public void a(Object o) {
        this.a.countDown();
        if (this.a.getCount() == 0) {
            this.c.n.set(true);
            this.c.i.a(this.c);
        }
    }

    public void a(Exception exception) {
        this.c.i.a(exception);
    }
}
