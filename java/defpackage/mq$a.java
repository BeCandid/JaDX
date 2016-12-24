package defpackage;

import java.util.Queue;

/* compiled from: ModelCache */
final class mq$a<A> {
    private static final Queue<mq$a<?>> a = ri.a(0);
    private int b;
    private int c;
    private A d;

    static <A> mq$a<A> a(A model, int width, int height) {
        mq$a<A> modelKey = (mq$a) a.poll();
        if (modelKey == null) {
            modelKey = new mq$a();
        }
        modelKey.b(model, width, height);
        return modelKey;
    }

    private mq$a() {
    }

    private void b(A model, int width, int height) {
        this.d = model;
        this.c = width;
        this.b = height;
    }

    public void a() {
        a.offer(this);
    }

    public boolean equals(Object o) {
        if (!(o instanceof mq$a)) {
            return false;
        }
        mq$a other = (mq$a) o;
        if (this.c == other.c && this.b == other.b && this.d.equals(other.d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.b * 31) + this.c) * 31) + this.d.hashCode();
    }
}
