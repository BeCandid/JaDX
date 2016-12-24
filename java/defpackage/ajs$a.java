package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TypeAdapters */
final class ajs$a<T extends Enum<T>> extends air<T> {
    private final Map<String, T> a = new HashMap();
    private final Map<T, String> b = new HashMap();

    public /* synthetic */ Object b(ajv ajv) throws IOException {
        return a(ajv);
    }

    public ajs$a(Class<T> classOfT) {
        try {
            for (T constant : (Enum[]) classOfT.getEnumConstants()) {
                String name = constant.name();
                aiv annotation = (aiv) classOfT.getField(name).getAnnotation(aiv.class);
                if (annotation != null) {
                    name = annotation.a();
                    for (String alternate : annotation.b()) {
                        this.a.put(alternate, constant);
                    }
                }
                this.a.put(name, constant);
                this.b.put(constant, name);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError("Missing field in " + classOfT.getName(), e);
        }
    }

    public T a(ajv in) throws IOException {
        if (in.f() != JsonToken.i) {
            return (Enum) this.a.get(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajw out, T value) throws IOException {
        out.b(value == null ? null : (String) this.b.get(value));
    }
}
