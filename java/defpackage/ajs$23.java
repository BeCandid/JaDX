package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajs$23 extends air<Boolean> {
    ajs$23() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Boolean a(ajv in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        } else if (in.f() == JsonToken.f) {
            return Boolean.valueOf(Boolean.parseBoolean(in.h()));
        } else {
            return Boolean.valueOf(in.i());
        }
    }

    public void a(ajw out, Boolean value) throws IOException {
        if (value == null) {
            out.f();
        } else {
            out.a(value.booleanValue());
        }
    }
}
