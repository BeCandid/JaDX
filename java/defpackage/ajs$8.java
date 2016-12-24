package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajs$8 extends air<String> {
    ajs$8() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public String a(ajv in) throws IOException {
        JsonToken peek = in.f();
        if (peek == JsonToken.i) {
            in.j();
            return null;
        } else if (peek == JsonToken.h) {
            return Boolean.toString(in.i());
        } else {
            return in.h();
        }
    }

    public void a(ajw out, String value) throws IOException {
        out.b(value);
    }
}
