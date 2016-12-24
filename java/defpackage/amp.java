package defpackage;

/* compiled from: RetryState */
public class amp {
    private final int a;
    private final aml b;
    private final amo c;

    public amp(aml backoff, amo retryPolicy) {
        this(0, backoff, retryPolicy);
    }

    public amp(int retryCount, aml backoff, amo retryPolicy) {
        this.a = retryCount;
        this.b = backoff;
        this.c = retryPolicy;
    }

    public long a() {
        return this.b.a(this.a);
    }

    public amp b() {
        return new amp(this.a + 1, this.b, this.c);
    }

    public amp c() {
        return new amp(this.b, this.c);
    }
}
