package defpackage;

import java.util.concurrent.ThreadFactory;

/* compiled from: PriorityThreadPoolExecutor */
public final class amj$a implements ThreadFactory {
    private final int a;

    public amj$a(int threadPriority) {
        this.a = threadPriority;
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(this.a);
        thread.setName("Queue");
        return thread;
    }
}
