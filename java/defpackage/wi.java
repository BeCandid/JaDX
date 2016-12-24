package defpackage;

import android.net.Uri;
import com.facebook.login.LoginClient.Request;
import java.util.Collection;

/* compiled from: DeviceLoginManager */
public class wi extends wm {
    private static volatile wi b;
    private Uri a;

    public static wi a() {
        if (b == null) {
            synchronized (wi.class) {
                if (b == null) {
                    b = new wi();
                }
            }
        }
        return b;
    }

    public void a(Uri uri) {
        this.a = uri;
    }

    public Uri b() {
        return this.a;
    }

    protected Request a(Collection<String> permissions) {
        Request request = super.a((Collection) permissions);
        Uri redirectUri = b();
        if (redirectUri != null) {
            request.a(redirectUri.toString());
        }
        return request;
    }
}
