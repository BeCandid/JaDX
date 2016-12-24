package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsCore */
class sz$4 implements Callable<Boolean> {
    final /* synthetic */ sz a;

    sz$4(sz szVar) {
        this.a = szVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Boolean a() throws Exception {
        return Boolean.valueOf(this.a.k.b());
    }
}
