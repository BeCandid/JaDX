package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: Engine */
class lc$e extends WeakReference<lh<?>> {
    private final kn a;

    public lc$e(kn key, lh<?> r, ReferenceQueue<? super lh<?>> q) {
        super(r, q);
        this.a = key;
    }
}
