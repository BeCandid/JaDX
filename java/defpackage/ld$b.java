package defpackage;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: EngineJob */
class ld$b implements Callback {
    private ld$b() {
    }

    public boolean handleMessage(Message message) {
        if (1 != message.what && 2 != message.what) {
            return false;
        }
        ld job = message.obj;
        if (1 == message.what) {
            job.b();
            return true;
        }
        job.c();
        return true;
    }
}
