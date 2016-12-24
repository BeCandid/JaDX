package defpackage;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

final class abg$a extends PhantomReference<xr<?>> {
    final /* synthetic */ abg a;
    private final int b;

    public abg$a(abg abg, xr xrVar, int i, ReferenceQueue<xr<?>> referenceQueue) {
        this.a = abg;
        super(xrVar, referenceQueue);
        this.b = i;
    }

    public void a() {
        this.a.m.sendMessage(this.a.m.obtainMessage(2, this.b, 2));
    }
}
