package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.Set;

public class abg implements Callback {
    private static final Object d = new Object();
    private static abg e;
    private long a;
    private long b;
    private long c;
    private final Context f;
    private final xd g;
    private int h;
    private final SparseArray<abg$c<?>> i;
    private final Map<aba<?>, abg$c<?>> j;
    private abf k;
    private final Set<aba<?>> l;
    private final Handler m;
    private final ReferenceQueue<xr<?>> n;
    private final SparseArray<abg$a> o;
    private abg$b p;

    public static abg a() {
        abg abg;
        synchronized (d) {
            abg = e;
        }
        return abg;
    }

    private void a(aaz aaz) {
        ((abg$c) this.i.get(aaz.a)).a(aaz);
    }

    private void a(xr<?> xrVar, int i) {
        aba d = xrVar.d();
        if (!this.j.containsKey(d)) {
            this.j.put(d, new abg$c(this, xrVar));
        }
        abg$c abg_c = (abg$c) this.j.get(d);
        abg_c.b(i);
        this.i.put(i, abg_c);
        abg_c.j();
        this.o.put(i, new abg$a(this, xrVar, i, this.n));
        if (this.p == null || !this.p.c.get()) {
            this.p = new abg$b(this.n, this.o);
            this.p.start();
        }
    }

    private void b(int i, boolean z) {
        abg$c abg_c = (abg$c) this.i.get(i);
        if (abg_c != null) {
            if (!z) {
                this.i.delete(i);
            }
            abg_c.a(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", "onRelease received for unknown instance: " + i, new Exception());
    }

    private void d() {
        for (abg$c abg_c : this.j.values()) {
            abg_c.b();
            abg_c.j();
        }
    }

    public void a(int i, boolean z) {
        this.m.sendMessage(this.m.obtainMessage(7, i, z ? 1 : 2));
    }

    public void a(abb abb) {
        for (aba aba : abb.b()) {
            abg$c abg_c = (abg$c) this.j.get(aba);
            if (abg_c == null) {
                abb.f();
                return;
            } else if (abg_c.d()) {
                abb.a(aba, ConnectionResult.a);
            } else if (abg_c.c() != null) {
                abb.a(aba, abg_c.c());
            } else {
                abg_c.a(abb);
            }
        }
    }

    public void a(abf abf) {
        synchronized (d) {
            if (abf == null) {
                this.k = null;
                this.l.clear();
            }
        }
    }

    boolean a(ConnectionResult connectionResult, int i) {
        if (!connectionResult.a() && !this.g.a(connectionResult.c())) {
            return false;
        }
        this.g.a(this.f, connectionResult, i);
        return true;
    }

    public void b() {
        this.m.sendMessage(this.m.obtainMessage(3));
    }

    public void b(ConnectionResult connectionResult, int i) {
        if (!a(connectionResult, i)) {
            this.m.sendMessage(this.m.obtainMessage(5, i, 0));
        }
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                a((abb) message.obj);
                break;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
            case uu$h.CardView_cardPreventCornerOverlap /*7*/:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                b(i, z);
                break;
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                d();
                break;
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                a((aaz) message.obj);
                break;
            case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                if (this.i.get(message.arg1) != null) {
                    ((abg$c) this.i.get(message.arg1)).a(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case uu$h.CardView_cardUseCompatPadding /*6*/:
                a((xr) message.obj, message.arg1);
                break;
            case uu$h.CardView_contentPadding /*8*/:
                if (this.j.containsKey(message.obj)) {
                    ((abg$c) this.j.get(message.obj)).e();
                    break;
                }
                break;
            case uu$h.CardView_contentPaddingLeft /*9*/:
                if (this.j.containsKey(message.obj)) {
                    ((abg$c) this.j.get(message.obj)).g();
                    break;
                }
                break;
            case uu$h.CardView_contentPaddingRight /*10*/:
                if (this.j.containsKey(message.obj)) {
                    ((abg$c) this.j.get(message.obj)).i();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }
}
