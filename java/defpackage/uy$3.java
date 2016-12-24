package defpackage;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.appevents.FlushReason;
import java.util.concurrent.TimeUnit;

/* compiled from: AppEventQueue */
class uy$3 implements Runnable {
    final /* synthetic */ AccessTokenAppIdPair a;
    final /* synthetic */ AppEvent b;

    uy$3(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        this.a = accessTokenAppIdPair;
        this.b = appEvent;
    }

    public void run() {
        uy.b.a(this.a, this.b);
        if (AppEventsLogger.a() != FlushBehavior.EXPLICIT_ONLY && uy.b.b() > 100) {
            uy.b(FlushReason.EVENT_THRESHOLD);
        } else if (uy.d == null) {
            uy.d = uy.c.schedule(uy.e, 15, TimeUnit.SECONDS);
        }
    }
}
