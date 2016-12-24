package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
/* compiled from: FroyoGestureDetector */
public class atf extends ate {
    protected final ScaleGestureDetector f;

    public atf(Context context) {
        super(context);
        this.f = new ScaleGestureDetector(context, new atf$1(this));
    }

    public boolean a() {
        return this.f.isInProgress();
    }

    public boolean c(MotionEvent ev) {
        try {
            this.f.onTouchEvent(ev);
            return super.c(ev);
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
