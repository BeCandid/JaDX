package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class aao$1 extends Handler {
    final /* synthetic */ aao a;

    aao$1(aao aao, Looper looper) {
        this.a = aao;
        super(looper);
    }

    public void handleMessage(Message message) {
        this.a.a(message);
    }
}
