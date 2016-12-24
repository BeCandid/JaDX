package defpackage;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: SnackbarManager */
class y$1 implements Callback {
    final /* synthetic */ y a;

    y$1(y yVar) {
        this.a = yVar;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                this.a.b((y$b) message.obj);
                return true;
            default:
                return false;
        }
    }
}
