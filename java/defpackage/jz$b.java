package defpackage;

/* compiled from: RequestManager */
public final class jz$b<A, T> {
    final /* synthetic */ jz a;
    private final mr<A, T> b;
    private final Class<T> c;

    jz$b(jz jzVar, mr<A, T> modelLoader, Class<T> dataClass) {
        this.a = jzVar;
        this.b = modelLoader;
        this.c = dataClass;
    }

    public jz$b$a a(A model) {
        return new jz$b$a(this, model);
    }
}
