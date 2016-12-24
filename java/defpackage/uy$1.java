package defpackage;

import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.appevents.FlushReason;

/* compiled from: AppEventQueue */
class uy$1 implements Runnable {
    uy$1() {
    }

    public void run() {
        uy.d = null;
        if (AppEventsLogger.a() != FlushBehavior.EXPLICIT_ONLY) {
            uy.b(FlushReason.TIMER);
        }
    }
}
