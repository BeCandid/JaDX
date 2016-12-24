package defpackage;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ObjectTypeAdapter */
public final class ajn extends air<Object> {
    public static final ais a = new ajn$1();
    private final aih b;

    ajn(aih gson) {
        this.b = gson;
    }

    public Object b(ajv in) throws IOException {
        switch (ajn$2.a[in.f().ordinal()]) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                List<Object> list = new ArrayList();
                in.a();
                while (in.e()) {
                    list.add(b(in));
                }
                in.b();
                return list;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                Map<String, Object> map = new LinkedTreeMap();
                in.c();
                while (in.e()) {
                    map.put(in.g(), b(in));
                }
                in.d();
                return map;
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return in.h();
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return Double.valueOf(in.k());
            case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                return Boolean.valueOf(in.i());
            case uu$h.CardView_cardUseCompatPadding /*6*/:
                in.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public void a(ajw out, Object value) throws IOException {
        if (value == null) {
            out.f();
            return;
        }
        air<Object> typeAdapter = this.b.a(value.getClass());
        if (typeAdapter instanceof ajn) {
            out.d();
            out.e();
            return;
        }
        typeAdapter.a(out, value);
    }
}
