package defpackage;

/* compiled from: RequestManager */
public final class jz$b$a {
    final /* synthetic */ jz$b a;
    private final A b;
    private final Class<A> c;
    private final boolean d = true;

    jz$b$a(jz$b jz_b, A model) {
        this.a = jz_b;
        this.b = model;
        this.c = jz.c((Object) model);
    }

    public <Z> jw<A, T, Z> a(Class<Z> resourceClass) {
        jw<A, T, Z> result = (jw) this.a.a.f.a(new jw(this.a.a.a, this.a.a.e, this.c, this.a.b, this.a.c, resourceClass, this.a.a.d, this.a.a.b, this.a.a.f));
        if (this.d) {
            result.b(this.b);
        }
        return result;
    }
}
