package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;

/* compiled from: ShareInternalUtility */
class wz$1 extends wx {
    final /* synthetic */ uk a;

    wz$1(uk callback, uk ukVar) {
        this.a = ukVar;
        super(callback);
    }

    public void a(vf appCall, Bundle results) {
        if (results != null) {
            String gesture = wz.a(results);
            if (gesture == null || "post".equalsIgnoreCase(gesture)) {
                wz.a(this.a, wz.b(results));
            } else if ("cancel".equalsIgnoreCase(gesture)) {
                wz.b(this.a);
            } else {
                wz.a(this.a, new FacebookException("UnknownError"));
            }
        }
    }

    public void a(vf appCall) {
        wz.b(this.a);
    }

    public void a(vf appCall, FacebookException error) {
        wz.a(this.a, error);
    }
}
