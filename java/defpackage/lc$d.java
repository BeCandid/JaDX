package defpackage;

import android.os.MessageQueue.IdleHandler;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Engine */
class lc$d implements IdleHandler {
    private final Map<kn, WeakReference<lh<?>>> a;
    private final ReferenceQueue<lh<?>> b;

    public lc$d(Map<kn, WeakReference<lh<?>>> activeResources, ReferenceQueue<lh<?>> queue) {
        this.a = activeResources;
        this.b = queue;
    }

    public boolean queueIdle() {
        lc$e ref = (lc$e) this.b.poll();
        if (ref != null) {
            this.a.remove(ref.a);
        }
        return true;
    }
}
