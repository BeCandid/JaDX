package defpackage;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: ResourceRecycler */
class lk$a implements Callback {
    private lk$a() {
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        message.obj.d();
        return true;
    }
}
