package defpackage;

/* compiled from: TypeAdapters */
class ajs$25 implements ais {
    final /* synthetic */ Class a;
    final /* synthetic */ air b;

    ajs$25(Class cls, air air) {
        this.a = cls;
        this.b = air;
    }

    public <T> air<T> a(aih gson, aju<T> typeToken) {
        return typeToken.getRawType() == this.a ? this.b : null;
    }

    public String toString() {
        return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
    }
}
