package defpackage;

/* compiled from: RxBus */
class ix$3 implements aqc<Object, Boolean> {
    final /* synthetic */ Class a;
    final /* synthetic */ ix b;

    ix$3(ix this$0, Class cls) {
        this.b = this$0;
        this.a = cls;
    }

    public /* synthetic */ Object call(Object obj) {
        return a(obj);
    }

    public Boolean a(Object o) {
        return Boolean.valueOf(o.getClass().equals(this.a));
    }
}
