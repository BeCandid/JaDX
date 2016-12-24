package defpackage;

import java.util.Random;

/* compiled from: RandomBackoff */
class sa implements aml {
    final aml a;
    final Random b;
    final double c;

    public sa(aml backoff, double jitterPercent) {
        this(backoff, jitterPercent, new Random());
    }

    public sa(aml backoff, double jitterPercent, Random random) {
        if (jitterPercent < 0.0d || jitterPercent > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (backoff == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random == null) {
            throw new NullPointerException("random must not be null");
        } else {
            this.a = backoff;
            this.c = jitterPercent;
            this.b = random;
        }
    }

    public long a(int retries) {
        return (long) (a() * ((double) this.a.a(retries)));
    }

    double a() {
        double minJitter = 1.0d - this.c;
        double maxJitter = 1.0d + this.c;
        return ((maxJitter - minJitter) * this.b.nextDouble()) + minJitter;
    }
}
