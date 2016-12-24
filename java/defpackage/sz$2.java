package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsCore */
class sz$2 implements Callable<Void> {
    final /* synthetic */ sz a;

    sz$2(sz szVar) {
        this.a = szVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        this.a.k.a();
        akx.h().a("CrashlyticsCore", "Initialization marker file created.");
        return null;
    }
}
