package defpackage;

import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager */
class y$b {
    private final WeakReference<y$a> a;
    private int b;

    y$b(int duration, y$a callback) {
        this.a = new WeakReference(callback);
        this.b = duration;
    }

    boolean a(y$a callback) {
        return callback != null && this.a.get() == callback;
    }
}
