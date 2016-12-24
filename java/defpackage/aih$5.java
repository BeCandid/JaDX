package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: Gson */
class aih$5 extends air<Number> {
    aih$5() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Number a(ajv in) throws IOException {
        if (in.f() != JsonToken.i) {
            return Long.valueOf(in.l());
        }
        in.j();
        return null;
    }

    public void a(ajw out, Number value) throws IOException {
        if (value == null) {
            out.f();
        } else {
            out.b(value.toString());
        }
    }
}
