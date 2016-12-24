package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aca$b extends aau {
    private static volatile aca$b[] g;
    public aca$c[] b;
    public String c;
    public Long d;
    public Long e;
    public Integer f;

    public aca$b() {
        f();
    }

    public static aca$b[] e() {
        if (g == null) {
            synchronized (aat.c) {
                if (g == null) {
                    g = new aca$b[0];
                }
            }
        }
        return g;
    }

    public /* synthetic */ aau a(aas aas) throws IOException {
        return b(aas);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null && this.b.length > 0) {
            for (aau aau : this.b) {
                if (aau != null) {
                    com_google_android_gms_internal_zzamc.a(1, aau);
                }
            }
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.b(3, this.d.longValue());
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.b(4, this.e.longValue());
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.a(5, this.f.intValue());
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aca$b b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    int b = aaw.b(aas, 10);
                    a = this.b == null ? 0 : this.b.length;
                    Object obj = new aca$c[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aca$c();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new aca$c();
                    aas.a(obj[a]);
                    this.b = obj;
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.c = aas.i();
                    continue;
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Long.valueOf(aas.f());
                    continue;
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.e = Long.valueOf(aas.f());
                    continue;
                case ha$a.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    this.f = Integer.valueOf(aas.g());
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
        if (this.b != null && this.b.length > 0) {
            for (aau aau : this.b) {
                if (aau != null) {
                    c += zzamc.b(1, aau);
                }
            }
        }
        if (this.c != null) {
            c += zzamc.b(2, this.c);
        }
        if (this.d != null) {
            c += zzamc.c(3, this.d.longValue());
        }
        if (this.e != null) {
            c += zzamc.c(4, this.e.longValue());
        }
        return this.f != null ? c + zzamc.b(5, this.f.intValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aca$b)) {
            return false;
        }
        aca$b aca_b = (aca$b) obj;
        if (!aat.a(this.b, aca_b.b)) {
            return false;
        }
        if (this.c == null) {
            if (aca_b.c != null) {
                return false;
            }
        } else if (!this.c.equals(aca_b.c)) {
            return false;
        }
        if (this.d == null) {
            if (aca_b.d != null) {
                return false;
            }
        } else if (!this.d.equals(aca_b.d)) {
            return false;
        }
        if (this.e == null) {
            if (aca_b.e != null) {
                return false;
            }
        } else if (!this.e.equals(aca_b.e)) {
            return false;
        }
        return this.f == null ? aca_b.f == null : this.f.equals(aca_b.f);
    }

    public aca$b f() {
        this.b = aca$c.e();
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + aat.a(this.b)) * 31)) * 31)) * 31)) * 31;
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
