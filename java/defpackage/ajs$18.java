package defpackage;

import java.io.IOException;
import java.util.Currency;

/* compiled from: TypeAdapters */
class ajs$18 extends air<Currency> {
    ajs$18() {
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Currency a(ajv in) throws IOException {
        return Currency.getInstance(in.h());
    }

    public void a(ajw out, Currency value) throws IOException {
        out.b(value.getCurrencyCode());
    }
}
