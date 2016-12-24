package defpackage;

import java.util.Map;

/* compiled from: PredefinedEvent */
public abstract class rz<T extends rz> extends rm<T> {
    final rl c = new rl(this.a);

    public abstract String b();

    public Map<String, Object> c() {
        return this.c.b;
    }

    public String toString() {
        return "{type:\"" + b() + '\"' + ", predefinedAttributes:" + this.c + ", customAttributes:" + this.b + "}";
    }
}
