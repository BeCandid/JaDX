package defpackage;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.facebook.AccessToken;

/* compiled from: AccessTokenTracker */
public abstract class ui {
    private final BroadcastReceiver a;
    private final bn b;
    private boolean c = false;

    public abstract void a(AccessToken accessToken, AccessToken accessToken2);

    public ui() {
        wf.a();
        this.a = new ui$a();
        this.b = bn.a(ul.f());
        a();
    }

    public void a() {
        if (!this.c) {
            d();
            this.c = true;
        }
    }

    public void b() {
        if (this.c) {
            this.b.a(this.a);
            this.c = false;
        }
    }

    public boolean c() {
        return this.c;
    }

    private void d() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        this.b.a(this.a, filter);
    }
}
