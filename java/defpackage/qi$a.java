package defpackage;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* compiled from: DrawableCrossFadeFactory */
class qi$a implements qn$a {
    private final int a;

    qi$a(int duration) {
        this.a = duration;
    }

    public Animation a() {
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration((long) this.a);
        return animation;
    }
}
