package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;

public class abe$a<R extends xk> extends Handler {
    public abe$a() {
        this(Looper.getMainLooper());
    }

    public abe$a(Looper looper) {
        super(looper);
    }

    public void a() {
        removeMessages(2);
    }

    public void a(xl<? super R> xlVar, R r) {
        sendMessage(obtainMessage(1, new Pair(xlVar, r)));
    }

    protected void b(xl<? super R> xlVar, R r) {
        try {
            xlVar.a(r);
        } catch (RuntimeException e) {
            abe.c((xk) r);
            throw e;
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                Pair pair = (Pair) message.obj;
                b((xl) pair.first, (xk) pair.second);
                return;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                ((abe) message.obj).c(Status.d);
                return;
            default:
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                return;
        }
    }
}
