package defpackage;

import android.os.Handler;

/* compiled from: HandlerScheduler */
public final class apw extends apo {
    private final Handler b;

    apw(Handler handler) {
        this.b = handler;
    }

    public apo$a createWorker() {
        return new apw$a(this.b);
    }
}
