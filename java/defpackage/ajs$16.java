package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.net.InetAddress;

/* compiled from: TypeAdapters */
class ajs$16 extends air<InetAddress> {
    ajs$16() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public InetAddress a(ajv in) throws IOException {
        if (in.f() != JsonToken.i) {
            return InetAddress.getByName(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajw out, InetAddress value) throws IOException {
        out.b(value == null ? null : value.getHostAddress());
    }
}
