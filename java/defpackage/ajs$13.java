package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajs$13 extends air<StringBuffer> {
    ajs$13() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public StringBuffer a(ajv in) throws IOException {
        if (in.f() != JsonToken.i) {
            return new StringBuffer(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajw out, StringBuffer value) throws IOException {
        out.b(value == null ? null : value.toString());
    }
}
