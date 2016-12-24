package defpackage;

import android.os.Handler;
import android.os.Message;

/* compiled from: PlatformServiceClient */
class wa$1 extends Handler {
    final /* synthetic */ wa a;

    wa$1(wa this$0) {
        this.a = this$0;
    }

    public void handleMessage(Message message) {
        this.a.a(message);
    }
}
