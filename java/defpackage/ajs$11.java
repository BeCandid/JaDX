package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajs$11 extends air<StringBuilder> {
    ajs$11() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public StringBuilder a(ajv in) throws IOException {
        if (in.f() != JsonToken.i) {
            return new StringBuilder(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajw out, StringBuilder value) throws IOException {
        out.b(value == null ? null : value.toString());
    }
}
