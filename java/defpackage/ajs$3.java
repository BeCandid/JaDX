package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajs$3 extends air<Number> {
    ajs$3() {
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
            return Long.valueOf(in.l());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    public void a(ajw out, Number value) throws IOException {
        out.a(value);
    }
}
