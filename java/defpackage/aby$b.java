package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aby$b extends aau {
    private static volatile aby$b[] g;
    public Integer b;
    public String c;
    public aby$c[] d;
    public Boolean e;
    public aby$d f;

    public aby$b() {
        f();
    }

    public static aby$b[] e() {
        if (g == null) {
            synchronized (aat.c) {
                if (g == null) {
                    g = new aby$b[0];
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
            com_google_android_gms_internal_zzamc.a(1, this.b.intValue());
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null && this.d.length > 0) {
            for (aau aau : this.d) {
                if (aau != null) {
                    com_google_android_gms_internal_zzamc.a(3, aau);
                }
            }
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.a(4, this.e.booleanValue());
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.a(5, this.f);
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aby$b b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    this.b = Integer.valueOf(aas.g());
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.c = aas.i();
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    int b = aaw.b(aas, 26);
                    a = this.d == null ? 0 : this.d.length;
                    Object obj = new aby$c[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aby$c();
                        aas.a(obj[a]);
                        aas.a();
                        a++;
                    }
                    obj[a] = new aby$c();
                    aas.a(obj[a]);
                    this.d = obj;
                    continue;
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.e = Boolean.valueOf(aas.h());
                    continue;
                case ha$a.AppCompatTheme_dialogTheme /*42*/:
                    if (this.f == null) {
                        this.f = new aby$d();
                    }
                    aas.a(this.f);
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
        if (this.d != null && this.d.length > 0) {
            int i = c;
            for (aau aau : this.d) {
                if (aau != null) {
                    i += zzamc.b(3, aau);
                }
            }
            c = i;
        }
        if (this.e != null) {
            c += zzamc.b(4, this.e.booleanValue());
        }
        return this.f != null ? c + zzamc.b(5, this.f) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aby$b)) {
            return false;
        }
        aby$b aby_b = (aby$b) obj;
        if (this.b == null) {
            if (aby_b.b != null) {
                return false;
            }
        } else if (!this.b.equals(aby_b.b)) {
            return false;
        }
        if (this.c == null) {
            if (aby_b.c != null) {
                return false;
            }
        } else if (!this.c.equals(aby_b.c)) {
            return false;
        }
        if (!aat.a(this.d, aby_b.d)) {
            return false;
        }
        if (this.e == null) {
            if (aby_b.e != null) {
                return false;
            }
        } else if (!this.e.equals(aby_b.e)) {
            return false;
        }
        return this.f == null ? aby_b.f == null : this.f.equals(aby_b.f);
    }

    public aby$b f() {
        this.b = null;
        this.c = null;
        this.d = aby$c.e();
        this.e = null;
        this.f = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.e == null ? 0 : this.e.hashCode()) + (((((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + aat.a(this.d)) * 31)) * 31;
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
