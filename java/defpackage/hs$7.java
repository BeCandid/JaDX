package defpackage;

import rx.schedulers.Schedulers;

/* compiled from: FeedFragment */
class hs$7 implements Runnable {
    final /* synthetic */ hs a;

    hs$7(hs this$0) {
        this.a = this$0;
    }

    public void run() {
        ik.a().a(this.a.c, null, this.a.b.b(this.a.c), 0).b(Schedulers.io()).a(apv.a()).b(new hs$7$1(this));
        this.a.h.postDelayed(this.a.k, 60000);
    }
}
