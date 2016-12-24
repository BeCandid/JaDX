package defpackage;

import java.util.Iterator;

/* compiled from: ConcurrentCircularArrayQueue */
public abstract class arf<E> extends arg<E> {
    protected static final int a = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long d = ((long) (asd.a.arrayBaseOffset(Object[].class) + (32 << (e - a))));
    private static final int e;
    protected final long b;
    protected final E[] c;

    static {
        int scale = asd.a.arrayIndexScale(Object[].class);
        if (4 == scale) {
            e = a + 2;
        } else if (8 == scale) {
            e = a + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
    }

    public arf(int capacity) {
        int actualCapacity = arn.a(capacity);
        this.b = (long) (actualCapacity - 1);
        this.c = new Object[((actualCapacity << a) + 64)];
    }

    protected final long a(long index) {
        return a(index, this.b);
    }

    protected final long a(long index, long mask) {
        return d + ((index & mask) << e);
    }

    protected final void a(long offset, E e) {
        a(this.c, offset, e);
    }

    protected final void a(E[] buffer, long offset, E e) {
        asd.a.putObject(buffer, offset, e);
    }

    protected final void b(E[] buffer, long offset, E e) {
        asd.a.putOrderedObject(buffer, offset, e);
    }

    protected final E b(long offset) {
        return a(this.c, offset);
    }

    protected final E a(E[] buffer, long offset) {
        return asd.a.getObject(buffer, offset);
    }

    protected final E c(long offset) {
        return b(this.c, offset);
    }

    protected final E b(E[] buffer, long offset) {
        return asd.a.getObjectVolatile(buffer, offset);
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }
}
