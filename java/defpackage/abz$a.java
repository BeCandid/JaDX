package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abz$a extends aau {
    private static volatile abz$a[] e;
    public String b;
    public Boolean c;
    public Boolean d;

    public abz$a() {
        f();
    }

    public static abz$a[] e() {
        if (e == null) {
            synchronized (aat.c) {
                if (e == null) {
                    e = new abz$a[0];
                }
            }
        }
        return e;
    }

    public /* synthetic */ aau a(aas aas) throws IOException {
        return b(aas);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.a(1, this.b);
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c.booleanValue());
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d.booleanValue());
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abz$a b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    this.b = aas.i();
                    continue;
                case ha$a.Toolbar_titleMarginBottom /*16*/:
                    this.c = Boolean.valueOf(aas.h());
                    continue;
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Boolean.valueOf(aas.h());
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
        if (this.c != null) {
            c += zzamc.b(2, this.c.booleanValue());
        }
        return this.d != null ? c + zzamc.b(3, this.d.booleanValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abz$a)) {
            return false;
        }
        abz$a abz_a = (abz$a) obj;
        if (this.b == null) {
            if (abz_a.b != null) {
                return false;
            }
        } else if (!this.b.equals(abz_a.b)) {
            return false;
        }
        if (this.c == null) {
            if (abz_a.c != null) {
                return false;
            }
        } else if (!this.c.equals(abz_a.c)) {
            return false;
        }
        return this.d == null ? abz_a.d == null : this.d.equals(abz_a.d);
    }

    public abz$a f() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return hashCode + i;
    }
}
