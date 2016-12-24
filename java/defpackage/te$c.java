package defpackage;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
final class te$c implements Runnable {
    private final sz a;
    private final File b;

    public te$c(sz crashlyticsCore, File fileToSend) {
        this.a = crashlyticsCore;
        this.b = fileToSend;
    }

    public void run() {
        if (CommonUtils.n(this.a.E())) {
            akx.h().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
            tg call = this.a.a(aoa.a().b());
            if (call != null) {
                new ts(call).a(new tu(this.b, te.f));
            }
        }
    }
}
