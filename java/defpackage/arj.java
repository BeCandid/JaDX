package defpackage;

/* compiled from: MpmcArrayQueue */
abstract class arj<E> extends arl<E> {
    private static final long e = asd.a(arj.class, "consumerIndex");
    private volatile long consumerIndex;

    public arj(int capacity) {
        super(capacity);
    }

    protected final long a() {
        return this.consumerIndex;
    }

    protected final boolean b(long expect, long newValue) {
        return asd.a.compareAndSwapLong(this, e, expect, newValue);
    }
}
