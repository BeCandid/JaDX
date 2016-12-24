package defpackage;

import com.facebook.appevents.FlushReason;

/* compiled from: AppEventQueue */
class uy$2 implements Runnable {
    final /* synthetic */ FlushReason a;

    uy$2(FlushReason flushReason) {
        this.a = flushReason;
    }

    public void run() {
        uy.b(this.a);
    }
}
