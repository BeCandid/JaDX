package defpackage;

import java.io.IOException;

/* compiled from: Excluder */
class aja$1 extends air<T> {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ aih c;
    final /* synthetic */ aju d;
    final /* synthetic */ aja e;
    private air<T> f;

    aja$1(aja this$0, boolean z, boolean z2, aih aih, aju aju) {
        this.e = this$0;
        this.a = z;
        this.b = z2;
        this.c = aih;
        this.d = aju;
    }

    public T b(ajv in) throws IOException {
        if (!this.a) {
            return b().b(in);
        }
        in.n();
        return null;
    }

    public void a(ajw out, T value) throws IOException {
        if (this.b) {
            out.f();
        } else {
            b().a(out, value);
        }
    }

    private air<T> b() {
        air<T> d = this.f;
        if (d != null) {
            return d;
        }
        d = this.c.a(this.e, this.d);
        this.f = d;
        return d;
    }
}
