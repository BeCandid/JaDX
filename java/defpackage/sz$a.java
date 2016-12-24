package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsCore */
final class sz$a implements Callable<Boolean> {
    private final tb a;

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public sz$a(tb crashMarker) {
        this.a = crashMarker;
    }

    public Boolean a() throws Exception {
        if (!this.a.b()) {
            return Boolean.FALSE;
        }
        akx.h().a("CrashlyticsCore", "Found previous crash marker.");
        this.a.c();
        return Boolean.TRUE;
    }
}
