package defpackage;

/* compiled from: OperatorOnErrorResumeNextViaFunction */
class aqo$1 implements aqc<Throwable, apl<? extends T>> {
    final /* synthetic */ aqc a;

    aqo$1(aqc aqc) {
        this.a = aqc;
    }

    public /* synthetic */ Object call(Object x0) {
        return a((Throwable) x0);
    }

    public apl<? extends T> a(Throwable t) {
        return apl.a(this.a.call(t));
    }
}
