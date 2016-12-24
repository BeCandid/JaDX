package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class aby$f extends aau {
    public Integer b;
    public String c;
    public Boolean d;
    public String[] e;

    public aby$f() {
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
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d.booleanValue());
        }
        if (this.e != null && this.e.length > 0) {
            for (String str : this.e) {
                if (str != null) {
                    com_google_android_gms_internal_zzamc.a(4, str);
                }
            }
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public aby$f b(aas aas) throws IOException {
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
                        case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                        case uu$h.CardView_cardUseCompatPadding /*6*/:
                            this.b = Integer.valueOf(a);
                            break;
                        default:
                            continue;
                    }
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.c = aas.i();
                    continue;
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Boolean.valueOf(aas.h());
                    continue;
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    int b = aaw.b(aas, 34);
                    a = this.e == null ? 0 : this.e.length;
                    Object obj = new String[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = aas.i();
                        aas.a();
                        a++;
                    }
                    obj[a] = aas.i();
                    this.e = obj;
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
        int i = 0;
        int c = super.c();
        if (this.b != null) {
            c += zzamc.b(1, this.b.intValue());
        }
        if (this.c != null) {
            c += zzamc.b(2, this.c);
        }
        if (this.d != null) {
            c += zzamc.b(3, this.d.booleanValue());
        }
        if (this.e == null || this.e.length <= 0) {
            return c;
        }
        int i2 = 0;
        int i3 = 0;
        while (i < this.e.length) {
            String str = this.e[i];
            if (str != null) {
                i3++;
                i2 += zzamc.b(str);
            }
            i++;
        }
        return (c + i2) + (i3 * 1);
    }

    public aby$f e() {
        this.c = null;
        this.d = null;
        this.e = aaw.f;
        this.a = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aby$f)) {
            return false;
        }
        aby$f aby_f = (aby$f) obj;
        if (this.b == null) {
            if (aby_f.b != null) {
                return false;
            }
        } else if (!this.b.equals(aby_f.b)) {
            return false;
        }
        if (this.c == null) {
            if (aby_f.c != null) {
                return false;
            }
        } else if (!this.c.equals(aby_f.c)) {
            return false;
        }
        if (this.d == null) {
            if (aby_f.d != null) {
                return false;
            }
        } else if (!this.d.equals(aby_f.d)) {
            return false;
        }
        return aat.a(this.e, aby_f.e);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return ((hashCode + i) * 31) + aat.a(this.e);
    }
}
