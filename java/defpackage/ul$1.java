package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FacebookSdk */
class ul$1 implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(0);

    ul$1() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "FacebookSdk #" + this.a.incrementAndGet());
    }
}
