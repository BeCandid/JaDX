package defpackage;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BackpressureUtils */
public final class aqg {
    public static long a(AtomicLong requested, long n) {
        long current;
        do {
            current = requested.get();
        } while (!requested.compareAndSet(current, aqg.a(current, n)));
        return current;
    }

    public static long a(long a, long b) {
        long u = a + b;
        if (u < 0) {
            return Long.MAX_VALUE;
        }
        return u;
    }
}
