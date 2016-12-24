package defpackage;

/* compiled from: SpmcArrayQueue */
abstract class aru<E> extends arq<E> {
    protected static final long e = asd.a(aru.class, "producerIndex");
    private volatile long producerIndex;

    protected final long b() {
        return this.producerIndex;
    }

    protected final void d(long v) {
        asd.a.putOrderedLong(this, e, v);
    }

    public aru(int capacity) {
        super(capacity);
    }
}
