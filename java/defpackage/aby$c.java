package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aby$c extends aau {
    private static volatile aby$c[] f;
    public aby$f b;
    public aby$d c;
    public Boolean d;
    public String e;

    public aby$c() {
        f();
    }

    public static aby$c[] e() {
        if (f == null) {
            synchronized (aat.c) {
                if (f == null) {
                    f = new aby$c[0];
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
            com_google_android_gms_internal_zzamc.a(1, this.b);
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d.booleanValue());
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.a(4, this.e);
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aby$c b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    if (this.b == null) {
                        this.b = new aby$f();
                    }
                    aas.a(this.b);
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    if (this.c == null) {
                        this.c = new aby$d();
                    }
                    aas.a(this.c);
                    continue;
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Boolean.valueOf(aas.h());
                    continue;
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.e = aas.i();
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
            c += zzamc.b(3, this.d.booleanValue());
        }
        return this.e != null ? c + zzamc.b(4, this.e) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aby$c)) {
            return false;
        }
        aby$c aby_c = (aby$c) obj;
        if (this.b == null) {
            if (aby_c.b != null) {
                return false;
            }
        } else if (!this.b.equals(aby_c.b)) {
            return false;
        }
        if (this.c == null) {
            if (aby_c.c != null) {
                return false;
            }
        } else if (!this.c.equals(aby_c.c)) {
            return false;
        }
        if (this.d == null) {
            if (aby_c.d != null) {
                return false;
            }
        } else if (!this.d.equals(aby_c.d)) {
            return false;
        }
        return this.e == null ? aby_c.e == null : this.e.equals(aby_c.e);
    }

    public aby$c f() {
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
