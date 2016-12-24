package defpackage;

import android.content.Context;

/* compiled from: MemoryValueCache */
public class ali<T> extends alh<T> {
    private T a;

    public ali() {
        this(null);
    }

    public ali(alj<T> childCache) {
        super(childCache);
    }

    protected T a(Context context) {
        return this.a;
    }

    protected void a(Context context, T value) {
        this.a = value;
    }
}
