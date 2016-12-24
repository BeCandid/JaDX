package defpackage;

import com.google.gson.JsonIOException;
import java.io.IOException;

/* compiled from: TypeAdapter */
public abstract class air<T> {
    public abstract void a(ajw ajw, T t) throws IOException;

    public abstract T b(ajv ajv) throws IOException;

    public final air<T> a() {
        return new air$1(this);
    }

    public final ail a(T value) {
        try {
            ajl jsonWriter = new ajl();
            a(jsonWriter, value);
            return jsonWriter.a();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
