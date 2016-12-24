package defpackage;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import com.crashlytics.android.answers.SessionEvent.Type;
import com.crashlytics.android.answers.SessionEvent.a;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx;

/* compiled from: EnabledSessionAnalyticsManagerStrategy */
class rw implements sg {
    final sh a;
    amv b;
    alr c = new alr();
    rx d = new ry();
    boolean e = true;
    boolean f = true;
    volatile int g = -1;
    private final alc h;
    private final anb i;
    private final Context j;
    private final sd k;
    private final ScheduledExecutorService l;
    private final AtomicReference<ScheduledFuture<?>> m = new AtomicReference();

    public rw(alc kit, Context context, ScheduledExecutorService executor, sd filesManager, anb httpRequestFactory, sh metadata) {
        this.h = kit;
        this.j = context;
        this.l = executor;
        this.k = filesManager;
        this.i = httpRequestFactory;
        this.a = metadata;
    }

    public void a(anl analyticsSettingsData, String protocolAndHostOverride) {
        this.b = rs.a(new se(this.h, protocolAndHostOverride, analyticsSettingsData.a, this.i, this.c.a(this.j)));
        this.k.a(analyticsSettingsData);
        this.e = analyticsSettingsData.f;
        akx.h().a("Answers", "Custom event tracking " + (this.e ? "enabled" : "disabled"));
        this.f = analyticsSettingsData.g;
        akx.h().a("Answers", "Predefined event tracking " + (this.f ? "enabled" : "disabled"));
        if (analyticsSettingsData.i > 1) {
            akx.h().a("Answers", "Event sampling enabled");
            this.d = new sc(analyticsSettingsData.i);
        }
        this.g = analyticsSettingsData.b;
        a(0, (long) this.g);
    }

    public void a(a builder) {
        SessionEvent event = builder.a(this.a);
        if (!this.e && Type.g.equals(event.c)) {
            akx.h().a("Answers", "Custom events tracking disabled - skipping event: " + event);
        } else if (!this.f && Type.h.equals(event.c)) {
            akx.h().a("Answers", "Predefined events tracking disabled - skipping event: " + event);
        } else if (this.d.a(event)) {
            akx.h().a("Answers", "Skipping filtered event: " + event);
        } else {
            try {
                this.k.a((Object) event);
            } catch (IOException e) {
                akx.h().e("Answers", "Failed to write event: " + event, e);
            }
            e();
        }
    }

    public void e() {
        if (this.g != -1) {
            a((long) this.g, (long) this.g);
        }
    }

    public void a() {
        if (this.b == null) {
            CommonUtils.a(this.j, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.a(this.j, "Sending all files");
        int filesSent = 0;
        List<File> batch = this.k.e();
        while (batch.size() > 0) {
            try {
                CommonUtils.a(this.j, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(batch.size())}));
                boolean cleanup = this.b.a(batch);
                if (cleanup) {
                    filesSent += batch.size();
                    this.k.a((List) batch);
                }
                if (!cleanup) {
                    break;
                }
                batch = this.k.e();
            } catch (Exception e) {
                CommonUtils.a(this.j, "Failed to send batch of analytics files to server: " + e.getMessage(), e);
            }
        }
        if (filesSent == 0) {
            this.k.g();
        }
    }

    public void d() {
        if (this.m.get() != null) {
            CommonUtils.a(this.j, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.m.get()).cancel(false);
            this.m.set(null);
        }
    }

    public void b() {
        this.k.f();
    }

    public boolean c() {
        try {
            return this.k.d();
        } catch (IOException e) {
            CommonUtils.a(this.j, "Failed to roll file over.", e);
            return false;
        }
    }

    void a(long initialDelaySecs, long frequencySecs) {
        if (this.m.get() == null) {
            Runnable rollOverRunnable = new amy(this.j, this);
            CommonUtils.a(this.j, "Scheduling time based file roll over every " + frequencySecs + " seconds");
            try {
                this.m.set(this.l.scheduleAtFixedRate(rollOverRunnable, initialDelaySecs, frequencySecs, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                CommonUtils.a(this.j, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
