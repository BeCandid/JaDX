package defpackage;

/* compiled from: OperatorOnBackpressureBuffer */
public class aqn<T> implements apl$b<T, T> {
    private final Long a;
    private final apy b;

    public /* synthetic */ Object call(Object x0) {
        return a((apr) x0);
    }

    aqn() {
        this.a = null;
        this.b = null;
    }

    public aqn(long capacity) {
        this(capacity, null);
    }

    public aqn(long capacity, apy onOverflow) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        this.a = Long.valueOf(capacity);
        this.b = onOverflow;
    }

    public apr<? super T> a(apr<? super T> child) {
        aqn$a<T> parent = new aqn$a(child, this.a, this.b);
        child.add(parent);
        child.setProducer(parent.c());
        return parent;
    }
}
