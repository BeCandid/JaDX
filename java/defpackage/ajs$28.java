package defpackage;

/* compiled from: TypeAdapters */
class ajs$28 implements ais {
    final /* synthetic */ Class a;
    final /* synthetic */ air b;

    ajs$28(Class cls, air air) {
        this.a = cls;
        this.b = air;
    }

    public <T2> air<T2> a(aih gson, aju<T2> typeToken) {
        Class<? super T2> requestedType = typeToken.getRawType();
        if (this.a.isAssignableFrom(requestedType)) {
            return new ajs$28$1(this, requestedType);
        }
        return null;
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.b + "]";
    }
}
