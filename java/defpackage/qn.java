package defpackage;

import android.view.View;

/* compiled from: ViewAnimation */
public class qn<R> implements qk<R> {
    private final qn$a a;

    qn(qn$a animationFactory) {
        this.a = animationFactory;
    }

    public boolean a(R r, qk$a adapter) {
        View view = adapter.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.a.a());
        }
        return false;
    }
}
