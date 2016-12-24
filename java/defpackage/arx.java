package defpackage;

/* compiled from: SpscArrayQueue */
abstract class arx<E> extends arf<E> {
    private static final Integer e = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int d;

    public arx(int capacity) {
        super(capacity);
        this.d = Math.min(capacity / 4, e.intValue());
    }
}
