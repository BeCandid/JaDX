package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aca$a extends aau {
    private static volatile aca$a[] f;
    public Integer b;
    public aca$f c;
    public aca$f d;
    public Boolean e;

    public aca$a() {
        f();
    }

    public static aca$a[] e() {
        if (f == null) {
            synchronized (aat.c) {
                if (f == null) {
                    f = new aca$a[0];
                }
            }
        }
        return f;
    }

    public /* synthetic */ aau a(aas aas) throws IOException {
        return b(aas);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.a(1, this.b.intValue());
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d);
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.a(4, this.e.booleanValue());
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aca$a b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    this.b = Integer.valueOf(aas.g());
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    if (this.c == null) {
                        this.c = new aca$f();
                    }
                    aas.a(this.c);
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    if (this.d == null) {
                        this.d = new aca$f();
                    }
                    aas.a(this.d);
                    continue;
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.e = Boolean.valueOf(aas.h());
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
            c += zzamc.b(1, this.b.intValue());
        }
        if (this.c != null) {
            c += zzamc.b(2, this.c);
        }
        if (this.d != null) {
            c += zzamc.b(3, this.d);
        }
        return this.e != null ? c + zzamc.b(4, this.e.booleanValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aca$a)) {
            return false;
        }
        aca$a aca_a = (aca$a) obj;
        if (this.b == null) {
            if (aca_a.b != null) {
                return false;
            }
        } else if (!this.b.equals(aca_a.b)) {
            return false;
        }
        if (this.c == null) {
            if (aca_a.c != null) {
                return false;
            }
        } else if (!this.c.equals(aca_a.c)) {
            return false;
        }
        if (this.d == null) {
            if (aca_a.d != null) {
                return false;
            }
        } else if (!this.d.equals(aca_a.d)) {
            return false;
        }
        return this.e == null ? aca_a.e == null : this.e.equals(aca_a.e);
    }

    public aca$a f() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        if (this.e != null) {
            i = this.e.hashCode();
        }
        return hashCode + i;
    }
}
