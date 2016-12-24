package defpackage;

/* compiled from: ExponentialBackoff */
public class amn implements aml {
    private final long a;
    private final int b;

    public amn(long baseTimeMillis, int power) {
        this.a = baseTimeMillis;
        this.b = power;
    }

    public long a(int retries) {
        return (long) (((double) this.a) * Math.pow((double) this.b, (double) retries));
    }
}
