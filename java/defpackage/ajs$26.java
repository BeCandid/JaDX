package defpackage;

/* compiled from: TypeAdapters */
class ajs$26 implements ais {
    final /* synthetic */ Class a;
    final /* synthetic */ Class b;
    final /* synthetic */ air c;

    ajs$26(Class cls, Class cls2, air air) {
        this.a = cls;
        this.b = cls2;
        this.c = air;
    }

    public <T> air<T> a(aih gson, aju<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        return (rawType == this.a || rawType == this.b) ? this.c : null;
    }

    public String toString() {
        return "Factory[type=" + this.b.getName() + "+" + this.a.getName() + ",adapter=" + this.c + "]";
    }
}
