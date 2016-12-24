package defpackage;

import java.util.concurrent.Callable;

/* compiled from: LockOnGetVariable */
class vw$1 implements Callable<Void> {
    final /* synthetic */ Callable a;
    final /* synthetic */ vw b;

    vw$1(vw this$0, Callable callable) {
        this.b = this$0;
        this.a = callable;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        try {
            this.b.a = this.a.call();
            return null;
        } finally {
            this.b.b.countDown();
        }
    }
}
