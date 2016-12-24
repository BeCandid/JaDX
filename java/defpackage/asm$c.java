package defpackage;

import java.util.concurrent.ThreadFactory;

/* compiled from: CachedThreadScheduler */
final class asm$c extends aqt {
    private long c = 0;

    asm$c(ThreadFactory threadFactory) {
        super(threadFactory);
    }

    public long c() {
        return this.c;
    }

    public void a(long expirationTime) {
        this.c = expirationTime;
    }
}
