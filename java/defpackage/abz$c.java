package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abz$c extends aau {
    private static volatile abz$c[] d;
    public String b;
    public String c;

    public abz$c() {
        f();
    }

    public static abz$c[] e() {
        if (d == null) {
            synchronized (aat.c) {
                if (d == null) {
                    d = new abz$c[0];
                }
            }
        }
        return d;
    }

    public /* synthetic */ aau a(aas aas) throws IOException {
        return b(aas);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.a(1, this.b);
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abz$c b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    this.b = aas.i();
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.c = aas.i();
                    continue;
                default:
                    if (!aaw.a(aas, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    protected int c() {
        int c = super.c();
        if (this.b != null) {
            c += zzamc.b(1, this.b);
        }
        return this.c != null ? c + zzamc.b(2, this.c) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abz$c)) {
            return false;
        }
        abz$c abz_c = (abz$c) obj;
        if (this.b == null) {
            if (abz_c.b != null) {
                return false;
            }
        } else if (!this.b.equals(abz_c.b)) {
            return false;
        }
        return this.c == null ? abz_c.c == null : this.c.equals(abz_c.c);
    }

    public abz$c f() {
        this.b = null;
        this.c = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
        if (this.c != null) {
            i = this.c.hashCode();
        }
        return hashCode + i;
    }
}
