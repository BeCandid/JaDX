package defpackage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker */
class lw$a {
    final Lock a;
    int b;

    private lw$a() {
        this.a = new ReentrantLock();
    }
}
