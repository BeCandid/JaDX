package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Gson */
class aih$6 extends air<AtomicLong> {
    final /* synthetic */ air a;

    aih$6(air air) {
        this.a = air;
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public void a(ajw out, AtomicLong value) throws IOException {
        this.a.a(out, Long.valueOf(value.get()));
    }

    public AtomicLong a(ajv in) throws IOException {
        return new AtomicLong(((Number) this.a.b(in)).longValue());
    }
}
