package defpackage;

import java.io.IOException;

/* compiled from: ReflectiveTypeAdapterFactory */
abstract class ajo$b {
    final String g;
    final boolean h;
    final boolean i;

    abstract void a(ajv ajv, Object obj) throws IOException, IllegalAccessException;

    abstract void a(ajw ajw, Object obj) throws IOException, IllegalAccessException;

    abstract boolean a(Object obj) throws IOException, IllegalAccessException;

    protected ajo$b(String name, boolean serialized, boolean deserialized) {
        this.g = name;
        this.h = serialized;
        this.i = deserialized;
    }
}
