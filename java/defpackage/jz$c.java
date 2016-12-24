package defpackage;

import java.io.InputStream;

/* compiled from: RequestManager */
public final class jz$c<T> {
    final /* synthetic */ jz a;
    private final mr<T, InputStream> b;

    jz$c(jz jzVar, mr<T, InputStream> loader) {
        this.a = jzVar;
        this.b = loader;
    }

    public ju<T> a(Class<T> modelClass) {
        return (ju) this.a.f.a(new ju(modelClass, this.b, null, this.a.a, this.a.e, this.a.d, this.a.b, this.a.f));
    }

    public ju<T> a(T model) {
        return (ju) a(jz.c((Object) model)).a((Object) model);
    }
}
