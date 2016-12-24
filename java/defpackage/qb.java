package defpackage;

import java.io.File;

/* compiled from: FixedLoadProvider */
public class qb<A, T, Z, R> implements qc<A, T, Z, R> {
    private final mr<A, T> a;
    private final pf<Z, R> b;
    private final py<T, Z> c;

    public qb(mr<A, T> modelLoader, pf<Z, R> transcoder, py<T, Z> dataLoadProvider) {
        if (modelLoader == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.a = modelLoader;
        if (transcoder == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.b = transcoder;
        if (dataLoadProvider == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.c = dataLoadProvider;
    }

    public mr<A, T> e() {
        return this.a;
    }

    public pf<Z, R> f() {
        return this.b;
    }

    public kp<File, Z> a() {
        return this.c.a();
    }

    public kp<T, Z> b() {
        return this.c.b();
    }

    public km<T> c() {
        return this.c.c();
    }

    public kq<Z> d() {
        return this.c.d();
    }
}
