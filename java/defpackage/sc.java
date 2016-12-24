package defpackage;

import com.crashlytics.android.answers.SamplingEventFilter.1;
import com.crashlytics.android.answers.SessionEvent;
import com.crashlytics.android.answers.SessionEvent.Type;
import java.util.Set;
import rx;

/* compiled from: SamplingEventFilter */
public class sc implements rx {
    static final Set<Type> b = new 1();
    final int a;

    public sc(int samplingRate) {
        this.a = samplingRate;
    }

    public boolean a(SessionEvent sessionEvent) {
        boolean canBeSampled;
        if (b.contains(sessionEvent.c) && sessionEvent.a.g == null) {
            canBeSampled = true;
        } else {
            canBeSampled = false;
        }
        boolean isSampledId;
        if (Math.abs(sessionEvent.a.c.hashCode() % this.a) != 0) {
            isSampledId = true;
        } else {
            isSampledId = false;
        }
        if (canBeSampled && isSampledId) {
            return true;
        }
        return false;
    }
}
