package defpackage;

import android.util.Log;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;

/* compiled from: ViewTarget */
class qz$a$a implements OnPreDrawListener {
    private final WeakReference<qz$a> a;

    public qz$a$a(qz$a sizeDeterminer) {
        this.a = new WeakReference(sizeDeterminer);
    }

    public boolean onPreDraw() {
        if (Log.isLoggable("ViewTarget", 2)) {
            Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
        }
        qz$a sizeDeterminer = (qz$a) this.a.get();
        if (sizeDeterminer != null) {
            sizeDeterminer.a();
        }
        return true;
    }
}
