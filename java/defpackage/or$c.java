package defpackage;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: GifFrameLoader */
class or$c implements Callback {
    final /* synthetic */ or a;

    private or$c(or orVar) {
        this.a = orVar;
    }

    public boolean handleMessage(Message msg) {
        if (msg.what == 1) {
            this.a.a(msg.obj);
            return true;
        }
        if (msg.what == 2) {
            jx.a((or$a) msg.obj);
        }
        return false;
    }
}
