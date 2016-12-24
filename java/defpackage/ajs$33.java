package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajs$33 extends air<Number> {
    ajs$33() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Number a(ajv in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        try {
            return Integer.valueOf(in.m());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    public void a(ajw out, Number value) throws IOException {
        out.a(value);
    }
}
