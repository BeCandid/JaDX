package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper */
final class ajr<T> extends air<T> {
    private final aih a;
    private final air<T> b;
    private final Type c;

    ajr(aih context, air<T> delegate, Type type) {
        this.a = context;
        this.b = delegate;
        this.c = type;
    }

    public T b(ajv in) throws IOException {
        return this.b.b(in);
    }

    public void a(ajw out, T value) throws IOException {
        air chosen = this.b;
        Type runtimeType = a(this.c, (Object) value);
        if (runtimeType != this.c) {
            air runtimeTypeAdapter = this.a.a(aju.get(runtimeType));
            if (!(runtimeTypeAdapter instanceof ajo$a)) {
                chosen = runtimeTypeAdapter;
            } else if (this.b instanceof ajo$a) {
                chosen = runtimeTypeAdapter;
            } else {
                chosen = this.b;
            }
        }
        chosen.a(out, value);
    }

    private Type a(Type type, Object value) {
        if (value == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return value.getClass();
        }
        return type;
    }
}
