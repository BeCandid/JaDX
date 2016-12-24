package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aby$e extends aau {
    private static volatile aby$e[] e;
    public Integer b;
    public String c;
    public aby$c d;

    public aby$e() {
        f();
    }

    public static aby$e[] e() {
        if (e == null) {
            synchronized (aat.c) {
                if (e == null) {
                    e = new aby$e[0];
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
            com_google_android_gms_internal_zzamc.a(1, this.b.intValue());
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d);
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aby$e b(aas aas) throws IOException {
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
                    if (this.d == null) {
                        this.d = new aby$c();
                    }
                    aas.a(this.d);
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
        return this.d != null ? c + zzamc.b(3, this.d) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aby$e)) {
            return false;
        }
        aby$e aby_e = (aby$e) obj;
        if (this.b == null) {
            if (aby_e.b != null) {
                return false;
            }
        } else if (!this.b.equals(aby_e.b)) {
            return false;
        }
        if (this.c == null) {
            if (aby_e.c != null) {
                return false;
            }
        } else if (!this.c.equals(aby_e.c)) {
            return false;
        }
        return this.d == null ? aby_e.d == null : this.d.equals(aby_e.d);
    }

    public aby$e f() {
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
