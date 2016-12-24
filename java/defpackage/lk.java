package defpackage;

import android.os.Handler;
import android.os.Looper;

/* compiled from: ResourceRecycler */
class lk {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new lk$a());

    lk() {
    }

    public void a(lj<?> resource) {
        ri.a();
        if (this.a) {
            this.b.obtainMessage(1, resource).sendToTarget();
            return;
        }
        this.a = true;
        resource.d();
        this.a = false;
    }
}
