package defpackage;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;

final class abp$a extends Handler {
    final /* synthetic */ abp a;

    public void handleMessage(Message message) {
        switch (message.what) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                xi xiVar = (xi) message.obj;
                synchronized (this.a.e) {
                    if (xiVar == null) {
                        this.a.b.a(new Status(13, "Transform returned null"));
                    } else if (xiVar instanceof abo) {
                        this.a.b.a(((abo) xiVar).b());
                    } else {
                        this.a.b.a(xiVar);
                    }
                }
                return;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String str = "TransformedResultImpl";
                String str2 = "Runtime exception on the transformation worker thread: ";
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                throw runtimeException;
            default:
                Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                return;
        }
    }
}
