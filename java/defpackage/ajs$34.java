package defpackage;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TypeAdapters */
class ajs$34 extends air<AtomicInteger> {
    ajs$34() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public AtomicInteger a(ajv in) throws IOException {
        try {
            return new AtomicInteger(in.m());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    public void a(ajw out, AtomicInteger value) throws IOException {
        out.a((long) value.get());
    }
}
