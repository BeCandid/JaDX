package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.net.URL;

/* compiled from: TypeAdapters */
class ajs$14 extends air<URL> {
    ajs$14() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public URL a(ajv in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        String nextString = in.h();
        if ("null".equals(nextString)) {
            return null;
        }
        return new URL(nextString);
    }

    public void a(ajw out, URL value) throws IOException {
        out.b(value == null ? null : value.toExternalForm());
    }
}
