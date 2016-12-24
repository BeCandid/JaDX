package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.HashMap;

final class yr extends yq implements Callback {
    private final HashMap<yr$a, yr$b> a = new HashMap();
    private final Context b;
    private final Handler c;
    private final ze d;
    private final long e;

    yr(Context context) {
        this.b = context.getApplicationContext();
        this.c = new Handler(context.getMainLooper(), this);
        this.d = ze.a();
        this.e = 5000;
    }

    private boolean a(yr$a yr_a, ServiceConnection serviceConnection, String str) {
        boolean a;
        xz.a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.a) {
            yr$b yr_b = (yr$b) this.a.get(yr_a);
            if (yr_b != null) {
                this.c.removeMessages(0, yr_b);
                if (!yr_b.a(serviceConnection)) {
                    yr_b.a(serviceConnection, str);
                    switch (yr_b.b()) {
                        case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                            serviceConnection.onServiceConnected(yr_b.e(), yr_b.d());
                            break;
                        case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                            yr_b.a(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(yr_a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            yr_b = new yr$b(this, yr_a);
            yr_b.a(serviceConnection, str);
            yr_b.a(str);
            this.a.put(yr_a, yr_b);
            a = yr_b.a();
        }
        return a;
    }

    private void b(yr$a yr_a, ServiceConnection serviceConnection, String str) {
        xz.a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.a) {
            yr$b yr_b = (yr$b) this.a.get(yr_a);
            String valueOf;
            if (yr_b == null) {
                valueOf = String.valueOf(yr_a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (yr_b.a(serviceConnection)) {
                yr_b.b(serviceConnection, str);
                if (yr_b.c()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, yr_b), this.e);
                }
            } else {
                valueOf = String.valueOf(yr_a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public boolean a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return a(new yr$a(str, str2), serviceConnection, str3);
    }

    public void b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        b(new yr$a(str, str2), serviceConnection, str3);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                yr$b yr_b = (yr$b) message.obj;
                synchronized (this.a) {
                    if (yr_b.c()) {
                        if (yr_b.a()) {
                            yr_b.b("GmsClientSupervisor");
                        }
                        this.a.remove(yr_b.g);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
