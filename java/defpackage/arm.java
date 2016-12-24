package defpackage;

/* compiled from: MpmcArrayQueue */
abstract class arm<E> extends ark<E> {
    private static final long e = asd.a(arm.class, "producerIndex");
    private volatile long producerIndex;

    public arm(int capacity) {
        super(capacity);
    }

    protected final long b() {
        return this.producerIndex;
    }

    protected final boolean c(long expect, long newValue) {
        return asd.a.compareAndSwapLong(this, e, expect, newValue);
    }
}
