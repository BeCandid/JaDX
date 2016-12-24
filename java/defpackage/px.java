package defpackage;

import java.io.File;

/* compiled from: ChildLoadProvider */
public class px<A, T, Z, R> implements Cloneable, qc<A, T, Z, R> {
    private final qc<A, T, Z, R> a;
    private kp<File, Z> b;
    private kp<T, Z> c;
    private kq<Z> d;
    private pf<Z, R> e;
    private km<T> f;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return g();
    }

    public px(qc<A, T, Z, R> parent) {
        this.a = parent;
    }

    public mr<A, T> e() {
        return this.a.e();
    }

    public void a(kp<T, Z> sourceDecoder) {
        this.c = sourceDecoder;
    }

    public void a(km<T> sourceEncoder) {
        this.f = sourceEncoder;
    }

    public kp<File, Z> a() {
        if (this.b != null) {
            return this.b;
        }
        return this.a.a();
    }

    public kp<T, Z> b() {
        if (this.c != null) {
            return this.c;
        }
        return this.a.b();
    }

    public km<T> c() {
        if (this.f != null) {
            return this.f;
        }
        return this.a.c();
    }

    public kq<Z> d() {
        if (this.d != null) {
            return this.d;
        }
        return this.a.d();
    }

    public pf<Z, R> f() {
        if (this.e != null) {
            return this.e;
        }
        return this.a.f();
    }

    public px<A, T, Z, R> g() {
        try {
            return (px) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
