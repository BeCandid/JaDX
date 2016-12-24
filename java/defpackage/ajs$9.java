package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;

/* compiled from: TypeAdapters */
class ajs$9 extends air<BigDecimal> {
    ajs$9() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public BigDecimal a(ajv in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        try {
            return new BigDecimal(in.h());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    public void a(ajw out, BigDecimal value) throws IOException {
        out.a((Number) value);
    }
}
