package defpackage;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: PhotoViewAttacher */
class atc$1 extends SimpleOnGestureListener {
    final /* synthetic */ atc a;

    atc$1(atc atc) {
        this.a = atc;
    }

    public void onLongPress(MotionEvent e) {
        if (this.a.u != null) {
            this.a.u.onLongClick(this.a.c());
        }
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (this.a.w == null || this.a.g() > 1.0f || em.c(e1) > atc.c || em.c(e2) > atc.c) {
            return false;
        }
        return this.a.w.a(e1, e2, velocityX, velocityY);
    }
}
