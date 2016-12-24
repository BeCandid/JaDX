package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class abs implements ThreadFactory {
    private final String a;
    private final int b;
    private final AtomicInteger c;
    private final ThreadFactory d;

    public abs(String str) {
        this(str, 0);
    }

    public abs(String str, int i) {
        this.c = new AtomicInteger();
        this.d = Executors.defaultThreadFactory();
        this.a = (String) xz.a((Object) str, (Object) "Name must not be null");
        this.b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.d.newThread(new abt(runnable, this.b));
        String str = this.a;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.c.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
