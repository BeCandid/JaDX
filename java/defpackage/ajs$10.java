package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigInteger;

/* compiled from: TypeAdapters */
class ajs$10 extends air<BigInteger> {
    ajs$10() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public BigInteger a(ajv in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        try {
            return new BigInteger(in.h());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    public void a(ajw out, BigInteger value) throws IOException {
        out.a((Number) value);
    }
}
