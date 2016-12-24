package defpackage;

import android.annotation.SuppressLint;

/* compiled from: LruResourceCache */
public class ma extends rf<kn, lj<?>> implements mb {
    private mb$a a;

    public /* synthetic */ lj a(kn x0) {
        return (lj) super.c(x0);
    }

    public /* bridge */ /* synthetic */ lj b(kn x0, lj x1) {
        return (lj) super.b(x0, x1);
    }

    public ma(int size) {
        super(size);
    }

    public void a(mb$a listener) {
        this.a = listener;
    }

    protected void a(kn key, lj<?> item) {
        if (this.a != null) {
            this.a.b(item);
        }
    }

    protected int a(lj<?> item) {
        return item.c();
    }

    @SuppressLint({"InlinedApi"})
    public void a(int level) {
        if (level >= 60) {
            a();
        } else if (level >= 40) {
            b(b() / 2);
        }
    }
}
