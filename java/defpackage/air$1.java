package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapter */
class air$1 extends air<T> {
    final /* synthetic */ air a;

    air$1(air this$0) {
        this.a = this$0;
    }

    public void a(ajw out, T value) throws IOException {
        if (value == null) {
            out.f();
        } else {
            this.a.a(out, value);
        }
    }

    public T b(ajv reader) throws IOException {
        if (reader.f() != JsonToken.i) {
            return this.a.b(reader);
        }
        reader.j();
        return null;
    }
}
