package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TypeAdapters */
class ajs$35 extends air<AtomicBoolean> {
    ajs$35() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public AtomicBoolean a(ajv in) throws IOException {
        return new AtomicBoolean(in.i());
    }

    public void a(ajw out, AtomicBoolean value) throws IOException {
        out.a(value.get());
    }
}
