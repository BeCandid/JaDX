package defpackage;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ActivityLifecycleTracker */
public class vc {
    private static final String a = vc.class.getCanonicalName();
    private static final ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();
    private static AtomicInteger c = new AtomicInteger(0);
    private static volatile ve d;
    private static AtomicBoolean e = new AtomicBoolean(false);

    public static UUID a() {
        return d != null ? d.a() : null;
    }
}
