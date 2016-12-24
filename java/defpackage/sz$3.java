package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsCore */
class sz$3 implements Callable<Boolean> {
    final /* synthetic */ sz a;

    sz$3(sz szVar) {
        this.a = szVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Boolean a() throws Exception {
        try {
            boolean removed = this.a.k.c();
            akx.h().a("CrashlyticsCore", "Initialization marker file removed: " + removed);
            return Boolean.valueOf(removed);
        } catch (Exception e) {
            akx.h().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
            return Boolean.valueOf(false);
        }
    }
}
