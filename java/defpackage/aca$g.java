package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aca$g extends aau {
    private static volatile aca$g[] h;
    public Long b;
    public String c;
    public String d;
    public Long e;
    public Float f;
    public Double g;

    public aca$g() {
        f();
    }

    public static aca$g[] e() {
        if (h == null) {
            synchronized (aat.c) {
                if (h == null) {
                    h = new aca$g[0];
                }
            }
        }
        return h;
    }

    public /* synthetic */ aau a(aas aas) throws IOException {
        return b(aas);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.b(1, this.b.longValue());
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d);
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.b(4, this.e.longValue());
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.a(5, this.f.floatValue());
        }
        if (this.g != null) {
            com_google_android_gms_internal_zzamc.a(6, this.g.doubleValue());
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aca$g b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    this.b = Long.valueOf(aas.f());
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.c = aas.i();
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    this.d = aas.i();
                    continue;
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.e = Long.valueOf(aas.f());
                    continue;
                case ha$a.AppCompatTheme_actionDropDownStyle /*45*/:
                    this.f = Float.valueOf(aas.d());
                    continue;
                case ha$a.AppCompatTheme_actionButtonStyle /*49*/:
                    this.g = Double.valueOf(aas.c());
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
            c += zzamc.c(1, this.b.longValue());
        }
        if (this.c != null) {
            c += zzamc.b(2, this.c);
        }
        if (this.d != null) {
            c += zzamc.b(3, this.d);
        }
        if (this.e != null) {
            c += zzamc.c(4, this.e.longValue());
        }
        if (this.f != null) {
            c += zzamc.b(5, this.f.floatValue());
        }
        return this.g != null ? c + zzamc.b(6, this.g.doubleValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aca$g)) {
            return false;
        }
        aca$g aca_g = (aca$g) obj;
        if (this.b == null) {
            if (aca_g.b != null) {
                return false;
            }
        } else if (!this.b.equals(aca_g.b)) {
            return false;
        }
        if (this.c == null) {
            if (aca_g.c != null) {
                return false;
            }
        } else if (!this.c.equals(aca_g.c)) {
            return false;
        }
        if (this.d == null) {
            if (aca_g.d != null) {
                return false;
            }
        } else if (!this.d.equals(aca_g.d)) {
            return false;
        }
        if (this.e == null) {
            if (aca_g.e != null) {
                return false;
            }
        } else if (!this.e.equals(aca_g.e)) {
            return false;
        }
        if (this.f == null) {
            if (aca_g.f != null) {
                return false;
            }
        } else if (!this.f.equals(aca_g.f)) {
            return false;
        }
        return this.g == null ? aca_g.g == null : this.g.equals(aca_g.g);
    }

    public aca$g f() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f == null ? 0 : this.f.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.g != null) {
            i = this.g.hashCode();
        }
        return hashCode + i;
    }
}
