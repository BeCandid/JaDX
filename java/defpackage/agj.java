package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class agj {
    final int a;
    final boolean b;
    final String c;
    final List<String> d;
    final String e;
    final boolean f;

    public agj(aby$f aby_f) {
        boolean z;
        boolean z2 = false;
        xz.a((Object) aby_f);
        if (aby_f.b == null || aby_f.b.intValue() == 0) {
            z = false;
        } else {
            if (aby_f.b.intValue() == 6) {
                if (aby_f.e == null || aby_f.e.length == 0) {
                    z = false;
                }
            } else if (aby_f.c == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.a = aby_f.b.intValue();
            if (aby_f.d != null && aby_f.d.booleanValue()) {
                z2 = true;
            }
            this.b = z2;
            if (this.b || this.a == 1 || this.a == 6) {
                this.c = aby_f.c;
            } else {
                this.c = aby_f.c.toUpperCase(Locale.ENGLISH);
            }
            this.d = aby_f.e == null ? null : a(aby_f.e, this.b);
            if (this.a == 1) {
                this.e = this.c;
            } else {
                this.e = null;
            }
        } else {
            this.a = 0;
            this.b = false;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.f = z;
    }

    private List<String> a(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        List<String> arrayList = new ArrayList();
        for (String toUpperCase : strArr) {
            arrayList.add(toUpperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean a(String str) {
        if (!this.f || str == null) {
            return null;
        }
        if (!(this.b || this.a == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.a) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return Boolean.valueOf(Pattern.compile(this.e, this.b ? 0 : 66).matcher(str).matches());
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return Boolean.valueOf(str.startsWith(this.c));
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return Boolean.valueOf(str.endsWith(this.c));
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return Boolean.valueOf(str.contains(this.c));
            case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                return Boolean.valueOf(str.equals(this.c));
            case uu$h.CardView_cardUseCompatPadding /*6*/:
                return Boolean.valueOf(this.d.contains(str));
            default:
                return null;
        }
    }
}
