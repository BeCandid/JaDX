package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aca$c extends aau {
    private static volatile aca$c[] g;
    public String b;
    public String c;
    public Long d;
    public Float e;
    public Double f;

    public aca$c() {
        f();
    }

    public static aca$c[] e() {
        if (g == null) {
            synchronized (aat.c) {
                if (g == null) {
                    g = new aca$c[0];
                }
            }
        }
        return g;
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
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.b(3, this.d.longValue());
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.a(4, this.e.floatValue());
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.a(5, this.f.doubleValue());
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aca$c b(aas aas) throws IOException {
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
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Long.valueOf(aas.f());
                    continue;
                case ha$a.AppCompatTheme_actionModeFindDrawable /*37*/:
                    this.e = Float.valueOf(aas.d());
                    continue;
                case ha$a.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                    this.f = Double.valueOf(aas.c());
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
            c += zzamc.b(2, this.c);
        }
        if (this.d != null) {
            c += zzamc.c(3, this.d.longValue());
        }
        if (this.e != null) {
            c += zzamc.b(4, this.e.floatValue());
        }
        return this.f != null ? c + zzamc.b(5, this.f.doubleValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aca$c)) {
            return false;
        }
        aca$c aca_c = (aca$c) obj;
        if (this.b == null) {
            if (aca_c.b != null) {
                return false;
            }
        } else if (!this.b.equals(aca_c.b)) {
            return false;
        }
        if (this.c == null) {
            if (aca_c.c != null) {
                return false;
            }
        } else if (!this.c.equals(aca_c.c)) {
            return false;
        }
        if (this.d == null) {
            if (aca_c.d != null) {
                return false;
            }
        } else if (!this.d.equals(aca_c.d)) {
            return false;
        }
        if (this.e == null) {
            if (aca_c.e != null) {
                return false;
            }
        } else if (!this.e.equals(aca_c.e)) {
            return false;
        }
        return this.f == null ? aca_c.f == null : this.f.equals(aca_c.f);
    }

    public aca$c f() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
