package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aby$d extends aau {
    public Integer b;
    public Boolean c;
    public String d;
    public String e;
    public String f;

    public aby$d() {
        e();
    }

    public /* synthetic */ aau a(aas aas) throws IOException {
        return b(aas);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.a(1, this.b.intValue());
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c.booleanValue());
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d);
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.a(4, this.e);
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.a(5, this.f);
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aby$d b(aas aas) throws IOException {
        while (true) {
            int a = aas.a();
            switch (a) {
                case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    a = aas.g();
                    switch (a) {
                        case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                        case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                            this.b = Integer.valueOf(a);
                            break;
                        default:
                            continue;
                    }
                case ha$a.Toolbar_titleMarginBottom /*16*/:
                    this.c = Boolean.valueOf(aas.h());
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    this.d = aas.i();
                    continue;
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.e = aas.i();
                    continue;
                case ha$a.AppCompatTheme_dialogTheme /*42*/:
                    this.f = aas.i();
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
            c += zzamc.b(2, this.c.booleanValue());
        }
        if (this.d != null) {
            c += zzamc.b(3, this.d);
        }
        if (this.e != null) {
            c += zzamc.b(4, this.e);
        }
        return this.f != null ? c + zzamc.b(5, this.f) : c;
    }

    public aby$d e() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aby$d)) {
            return false;
        }
        aby$d aby_d = (aby$d) obj;
        if (this.b == null) {
            if (aby_d.b != null) {
                return false;
            }
        } else if (!this.b.equals(aby_d.b)) {
            return false;
        }
        if (this.c == null) {
            if (aby_d.c != null) {
                return false;
            }
        } else if (!this.c.equals(aby_d.c)) {
            return false;
        }
        if (this.d == null) {
            if (aby_d.d != null) {
                return false;
            }
        } else if (!this.d.equals(aby_d.d)) {
            return false;
        }
        if (this.e == null) {
            if (aby_d.e != null) {
                return false;
            }
        } else if (!this.e.equals(aby_d.e)) {
            return false;
        }
        return this.f == null ? aby_d.f == null : this.f.equals(aby_d.f);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
