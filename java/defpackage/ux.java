package defpackage;

import android.content.Context;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.PersistedEvents;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: AppEventCollection */
class ux {
    private final HashMap<AccessTokenAppIdPair, vb> a = new HashMap();

    public synchronized void a(PersistedEvents persistedEvents) {
        if (persistedEvents != null) {
            for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
                vb sessionEventsState = b(accessTokenAppIdPair);
                for (AppEvent appEvent : (List) persistedEvents.get(accessTokenAppIdPair)) {
                    sessionEventsState.a(appEvent);
                }
            }
        }
    }

    public synchronized void a(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        b(accessTokenAppIdPair).a(appEvent);
    }

    public synchronized Set<AccessTokenAppIdPair> a() {
        return this.a.keySet();
    }

    public synchronized vb a(AccessTokenAppIdPair accessTokenAppIdPair) {
        return (vb) this.a.get(accessTokenAppIdPair);
    }

    public synchronized int b() {
        int count;
        count = 0;
        for (vb sessionEventsState : this.a.values()) {
            count += sessionEventsState.a();
        }
        return count;
    }

    private synchronized vb b(AccessTokenAppIdPair accessTokenAppId) {
        vb eventsState;
        eventsState = (vb) this.a.get(accessTokenAppId);
        if (eventsState == null) {
            Context context = AppEventsLogger.d();
            eventsState = new vb(vg.a(context), AppEventsLogger.b(context));
        }
        this.a.put(accessTokenAppId, eventsState);
        return eventsState;
    }
}
