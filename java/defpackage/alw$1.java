package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils */
class alw$1 implements ThreadFactory {
    final /* synthetic */ String a;
    final /* synthetic */ AtomicLong b;

    alw$1(String str, AtomicLong atomicLong) {
        this.a = str;
        this.b = atomicLong;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = Executors.defaultThreadFactory().newThread(new alw$1$1(this, runnable));
        thread.setName(this.a + this.b.getAndIncrement());
        return thread;
    }
}
