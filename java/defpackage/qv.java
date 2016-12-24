package defpackage;

/* compiled from: SimpleTarget */
public abstract class qv<Z> extends qp<Z> {
    private final int a;
    private final int b;

    public qv() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public qv(int width, int height) {
        this.a = width;
        this.b = height;
    }

    public final void getSize(qw cb) {
        if (ri.a(this.a, this.b)) {
            cb.a(this.a, this.b);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.a + " and height: " + this.b + ", either provide dimensions in the constructor" + " or call override()");
    }
}
