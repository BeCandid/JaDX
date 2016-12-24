package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajs$4 extends air<Number> {
    ajs$4() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Number a(ajv in) throws IOException {
        if (in.f() != JsonToken.i) {
            return Float.valueOf((float) in.k());
        }
        in.j();
        return null;
    }

    public void a(ajw out, Number value) throws IOException {
        out.a(value);
    }
}
