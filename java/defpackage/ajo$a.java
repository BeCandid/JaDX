package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory */
public final class ajo$a<T> extends air<T> {
    private final ajc<T> a;
    private final Map<String, ajo$b> b;

    ajo$a(ajc<T> constructor, Map<String, ajo$b> boundFields) {
        this.a = constructor;
        this.b = boundFields;
    }

    public T b(ajv in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        T instance = this.a.a();
        try {
            in.c();
            while (in.e()) {
                ajo$b field = (ajo$b) this.b.get(in.g());
                if (field == null || !field.i) {
                    in.n();
                } else {
                    field.a(in, (Object) instance);
                }
            }
            in.d();
            return instance;
        } catch (IllegalStateException e) {
            throw new JsonSyntaxException(e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public void a(ajw out, T value) throws IOException {
        if (value == null) {
            out.f();
            return;
        }
        out.d();
        try {
            for (ajo$b boundField : this.b.values()) {
                if (boundField.a(value)) {
                    out.a(boundField.g);
                    boundField.a(out, (Object) value);
                }
            }
            out.e();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
