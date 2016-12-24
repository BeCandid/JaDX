package defpackage;

import java.util.HashMap;
import java.util.Map;

/* compiled from: DiskCacheWriteLocker */
final class lw {
    private final Map<kn, lw$a> a = new HashMap();
    private final lw$b b = new lw$b(null);

    lw() {
    }

    void a(kn key) {
        lw$a writeLock;
        synchronized (this) {
            writeLock = (lw$a) this.a.get(key);
            if (writeLock == null) {
                writeLock = this.b.a();
                this.a.put(key, writeLock);
            }
            writeLock.b++;
        }
        writeLock.a.lock();
    }

    void b(kn key) {
        lw$a writeLock;
        synchronized (this) {
            writeLock = (lw$a) this.a.get(key);
            int i;
            if (writeLock == null || writeLock.b <= 0) {
                StringBuilder append = new StringBuilder().append("Cannot release a lock that is not held, key: ").append(key).append(", interestedThreads: ");
                if (writeLock == null) {
                    i = 0;
                } else {
                    i = writeLock.b;
                }
                throw new IllegalArgumentException(append.append(i).toString());
            }
            i = writeLock.b - 1;
            writeLock.b = i;
            if (i == 0) {
                lw$a removed = (lw$a) this.a.remove(key);
                if (removed.equals(writeLock)) {
                    this.b.a(removed);
                } else {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + removed + ", key: " + key);
                }
            }
        }
        writeLock.a.unlock();
    }
}
