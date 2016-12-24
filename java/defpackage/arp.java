package defpackage;

/* compiled from: SpmcArrayQueue */
abstract class arp<E> extends arr<E> {
    protected static final long d = asd.a(arp.class, "consumerIndex");
    private volatile long consumerIndex;

    public arp(int capacity) {
        super(capacity);
    }

    protected final long a() {
        return this.consumerIndex;
    }

    protected final boolean b(long expect, long newValue) {
        return asd.a.compareAndSwapLong(this, d, expect, newValue);
    }
}
