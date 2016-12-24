package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class aic$1 extends Handler {
    final /* synthetic */ aic a;

    aic$1(aic aic, Looper looper) {
        this.a = aic;
        super(looper);
    }

    public void handleMessage(Message message) {
        this.a.a(message);
    }
}
