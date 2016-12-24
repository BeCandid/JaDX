package defpackage;

import java.io.IOException;

/* compiled from: Gson */
class aih$a<T> extends air<T> {
    private air<T> a;

    aih$a() {
    }

    public void a(air<T> typeAdapter) {
        if (this.a != null) {
            throw new AssertionError();
        }
        this.a = typeAdapter;
    }

    public T b(ajv in) throws IOException {
        if (this.a != null) {
            return this.a.b(in);
        }
        throw new IllegalStateException();
    }

    public void a(ajw out, T value) throws IOException {
        if (this.a == null) {
            throw new IllegalStateException();
        }
        this.a.a(out, value);
    }
}
