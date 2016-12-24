package defpackage;

/* compiled from: ViewAnimationFactory */
public class qo<R> implements ql<R> {
    private final qn$a a;
    private qk<R> b;

    qo(qn$a animationFactory) {
        this.a = animationFactory;
    }

    public qk<R> a(boolean isFromMemoryCache, boolean isFirstResource) {
        if (isFromMemoryCache || !isFirstResource) {
            return qm.b();
        }
        if (this.b == null) {
            this.b = new qn(this.a);
        }
        return this.b;
    }
}
