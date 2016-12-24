package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: Gson */
class aih$4 extends air<Number> {
    final /* synthetic */ aih a;

    aih$4(aih this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public Float a(ajv in) throws IOException {
        if (in.f() != JsonToken.i) {
            return Float.valueOf((float) in.k());
        }
        in.j();
        return null;
    }

    public void a(ajw out, Number value) throws IOException {
        if (value == null) {
            out.f();
            return;
        }
        aih.a((double) value.floatValue());
        out.a(value);
    }
}
