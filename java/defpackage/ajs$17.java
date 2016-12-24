package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.UUID;

/* compiled from: TypeAdapters */
class ajs$17 extends air<UUID> {
    ajs$17() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public UUID a(ajv in) throws IOException {
        if (in.f() != JsonToken.i) {
            return UUID.fromString(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajw out, UUID value) throws IOException {
        out.b(value == null ? null : value.toString());
    }
}
