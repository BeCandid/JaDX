package defpackage;

import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: DiskCacheWriteLocker */
class lw$b {
    private final Queue<lw$a> a;

    private lw$b() {
        this.a = new ArrayDeque();
    }

    lw$a a() {
        synchronized (this.a) {
            lw$a result = (lw$a) this.a.poll();
        }
        if (result == null) {
            return new lw$a(null);
        }
        return result;
    }

    void a(lw$a writeLock) {
        synchronized (this.a) {
            if (this.a.size() < 10) {
                this.a.offer(writeLock);
            }
        }
    }
}
