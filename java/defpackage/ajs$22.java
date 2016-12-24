package defpackage;

import com.google.gson.internal.LazilyParsedNumber;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: TypeAdapters */
class ajs$22 extends air<ail> {
    ajs$22() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public ail a(ajv in) throws IOException {
        switch (ajs$29.a[in.f().ordinal()]) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return new aip(new LazilyParsedNumber(in.h()));
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return new aip(Boolean.valueOf(in.i()));
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return new aip(in.h());
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                in.j();
                return aim.a;
            case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                ail array = new aij();
                in.a();
                while (in.e()) {
                    array.a(a(in));
                }
                in.b();
                return array;
            case uu$h.CardView_cardUseCompatPadding /*6*/:
                ail object = new ain();
                in.c();
                while (in.e()) {
                    object.a(in.g(), a(in));
                }
                in.d();
                return object;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void a(ajw out, ail value) throws IOException {
        if (value == null || value.l()) {
            out.f();
        } else if (value.k()) {
            aip primitive = value.o();
            if (primitive.q()) {
                out.a(primitive.b());
            } else if (primitive.a()) {
                out.a(primitive.h());
            } else {
                out.b(primitive.c());
            }
        } else if (value.i()) {
            out.b();
            Iterator it = value.n().iterator();
            while (it.hasNext()) {
                a(out, (ail) it.next());
            }
            out.c();
        } else if (value.j()) {
            out.d();
            for (Entry<String, ail> e : value.m().a()) {
                out.a((String) e.getKey());
                a(out, (ail) e.getValue());
            }
            out.e();
        } else {
            throw new IllegalArgumentException("Couldn't write " + value.getClass());
        }
    }
}
