package defpackage;

public final class xf<O extends xf$a> {
    private final xf$b<?, O> a;
    private final xf$i<?, O> b = null;
    private final xf$g<?> c;
    private final xf$j<?> d;
    private final String e;

    public <C extends xf$f> xf(String str, xf$b<C, O> xf_b_C__O, xf$g<C> xf_g_C) {
        xz.a((Object) xf_b_C__O, (Object) "Cannot construct an Api with a null ClientBuilder");
        xz.a((Object) xf_g_C, (Object) "Cannot construct an Api with a null ClientKey");
        this.e = str;
        this.a = xf_b_C__O;
        this.c = xf_g_C;
        this.d = null;
    }

    public xf$b<?, O> a() {
        xz.a(this.a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }

    public xf$i<?, O> b() {
        xz.a(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public xf$d<?> c() {
        if (this.c != null) {
            return this.c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.e;
    }
}
