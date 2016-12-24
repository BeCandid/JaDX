package defpackage;

/* compiled from: OperatorOnErrorResumeNextViaFunction */
public final class aqo<T> implements apl$b<T, T> {
    final aqc<Throwable, ? extends apl<? extends T>> a;

    public /* synthetic */ Object call(Object x0) {
        return a((apr) x0);
    }

    public static <T> aqo<T> a(aqc<Throwable, ? extends T> resumeFunction) {
        return new aqo(new aqo$1(resumeFunction));
    }

    public aqo(aqc<Throwable, ? extends apl<? extends T>> f) {
        this.a = f;
    }

    public apr<? super T> a(apr<? super T> child) {
        aqq pa = new aqq();
        asx ssub = new asx();
        apr<T> parent = new aqo$2(this, child, pa, ssub);
        ssub.a(parent);
        child.add(ssub);
        child.setProducer(pa);
        return parent;
    }
}
