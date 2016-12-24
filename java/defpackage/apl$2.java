package defpackage;

/* compiled from: Observable */
class apl$2 implements apl$a<R> {
    final /* synthetic */ apl$b a;
    final /* synthetic */ apl b;

    apl$2(apl apl, apl$b apl_b) {
        this.b = apl;
        this.a = apl_b;
    }

    public /* synthetic */ void call(Object x0) {
        a((apr) x0);
    }

    public void a(apr<? super R> o) {
        apr<? super T> st;
        try {
            st = (apr) apl.b.a(this.a).call(o);
            st.onStart();
            this.b.a.call(st);
        } catch (Throwable e) {
            apx.a(e);
            o.onError(e);
        }
    }
}
