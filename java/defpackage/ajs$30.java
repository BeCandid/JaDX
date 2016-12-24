package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajs$30 extends air<Boolean> {
    ajs$30() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Boolean a(ajv in) throws IOException {
        if (in.f() != JsonToken.i) {
            return Boolean.valueOf(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajw out, Boolean value) throws IOException {
        out.b(value == null ? "null" : value.toString());
    }
}
