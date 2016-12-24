package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abz$b extends aau {
    public Long b;
    public String c;
    public Integer d;
    public abz$c[] e;
    public abz$a[] f;
    public aby$a[] g;

    public abz$b() {
        e();
    }

    public /* synthetic */ aau a(aas aas) throws IOException {
        return b(aas);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        int i = 0;
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.b(1, this.b.longValue());
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d.intValue());
        }
        if (this.e != null && this.e.length > 0) {
            for (aau aau : this.e) {
                if (aau != null) {
                    com_google_android_gms_internal_zzamc.a(4, aau);
                }
            }
        }
        if (this.f != null && this.f.length > 0) {
            for (aau aau2 : this.f) {
                if (aau2 != null) {
                    com_google_android_gms_internal_zzamc.a(5, aau2);
                }
            }
        }
        if (this.g != null && this.g.length > 0) {
            while (i < this.g.length) {
                aau aau3 = this.g[i];
                if (aau3 != null) {
                    com_google_android_gms_internal_zzamc.a(6, aau3);
                }
                i++;
            }
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abz$b b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            int b;
            Object obj;
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    this.b = Long.valueOf(aas.f());
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.c = aas.i();
                    continue;
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Integer.valueOf(aas.g());
                    continue;
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    b = aaw.b(aas, 34);
                    a = this.e == null ? 0 : this.e.length;
                    obj = new abz$c[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abz$c();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new abz$c();
                    aas.a(obj[a]);
                    this.e = obj;
                    continue;
                case ha$a.AppCompatTheme_dialogTheme /*42*/:
                    b = aaw.b(aas, 42);
                    a = this.f == null ? 0 : this.f.length;
                    obj = new abz$a[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abz$a();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new abz$a();
                    aas.a(obj[a]);
                    this.f = obj;
                    continue;
                case ha$a.AppCompatTheme_buttonBarStyle /*50*/:
                    b = aaw.b(aas, 50);
                    a = this.g == null ? 0 : this.g.length;
                    obj = new aby$a[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.g, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aby$a();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new aby$a();
                    aas.a(obj[a]);
                    this.g = obj;
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
        int i;
        int i2 = 0;
        int c = super.c();
        if (this.b != null) {
            c += zzamc.c(1, this.b.longValue());
        }
        if (this.c != null) {
            c += zzamc.b(2, this.c);
        }
        if (this.d != null) {
            c += zzamc.b(3, this.d.intValue());
        }
        if (this.e != null && this.e.length > 0) {
            i = c;
            for (aau aau : this.e) {
                if (aau != null) {
                    i += zzamc.b(4, aau);
                }
            }
            c = i;
        }
        if (this.f != null && this.f.length > 0) {
            i = c;
            for (aau aau2 : this.f) {
                if (aau2 != null) {
                    i += zzamc.b(5, aau2);
                }
            }
            c = i;
        }
        if (this.g != null && this.g.length > 0) {
            while (i2 < this.g.length) {
                aau aau3 = this.g[i2];
                if (aau3 != null) {
                    c += zzamc.b(6, aau3);
                }
                i2++;
            }
        }
        return c;
    }

    public abz$b e() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = abz$c.e();
        this.f = abz$a.e();
        this.g = aby$a.e();
        this.a = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abz$b)) {
            return false;
        }
        abz$b abz_b = (abz$b) obj;
        if (this.b == null) {
            if (abz_b.b != null) {
                return false;
            }
        } else if (!this.b.equals(abz_b.b)) {
            return false;
        }
        if (this.c == null) {
            if (abz_b.c != null) {
                return false;
            }
        } else if (!this.c.equals(abz_b.c)) {
            return false;
        }
        if (this.d == null) {
            if (abz_b.d != null) {
                return false;
            }
        } else if (!this.d.equals(abz_b.d)) {
            return false;
        }
        return !aat.a(this.e, abz_b.e) ? false : !aat.a(this.f, abz_b.f) ? false : aat.a(this.g, abz_b.g);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return ((((((hashCode + i) * 31) + aat.a(this.e)) * 31) + aat.a(this.f)) * 31) + aat.a(this.g);
    }
}
