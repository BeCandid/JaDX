package defpackage;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCrossFadeFactory */
public class qi<T extends Drawable> implements ql<T> {
    private final qo<T> a;
    private final int b;
    private qj<T> c;
    private qj<T> d;

    public qi() {
        this(300);
    }

    public qi(int duration) {
        this(new qo(new qi$a(duration)), duration);
    }

    qi(qo<T> animationFactory, int duration) {
        this.a = animationFactory;
        this.b = duration;
    }

    public qk<T> a(boolean isFromMemoryCache, boolean isFirstResource) {
        if (isFromMemoryCache) {
            return qm.b();
        }
        if (isFirstResource) {
            return a();
        }
        return b();
    }

    private qk<T> a() {
        if (this.c == null) {
            this.c = new qj(this.a.a(false, true), this.b);
        }
        return this.c;
    }

    private qk<T> b() {
        if (this.d == null) {
            this.d = new qj(this.a.a(false, false), this.b);
        }
        return this.d;
    }
}
