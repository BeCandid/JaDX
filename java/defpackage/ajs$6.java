package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajs$6 extends air<Number> {
    ajs$6() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Number a(ajv in) throws IOException {
        JsonToken jsonToken = in.f();
        switch (ajs$29.a[jsonToken.ordinal()]) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return new LazilyParsedNumber(in.h());
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                in.j();
                return null;
            default:
                throw new JsonSyntaxException("Expecting number, got: " + jsonToken);
        }
    }

    public void a(ajw out, Number value) throws IOException {
        out.a(value);
    }
}
