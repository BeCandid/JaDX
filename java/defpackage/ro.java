package defpackage;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent.a;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: AnswersEventsHandler */
class ro implements amt {
    final ScheduledExecutorService a;
    sg b = new rv();
    private final alc c;
    private final Context d;
    private final rp e;
    private final sj f;
    private final anb g;

    public ro(alc kit, Context context, rp filesManagerProvider, sj metadataCollector, anb requestFactory, ScheduledExecutorService executor) {
        this.c = kit;
        this.d = context;
        this.e = filesManagerProvider;
        this.f = metadataCollector;
        this.g = requestFactory;
        this.a = executor;
    }

    public void a(a eventBuilder) {
        a(eventBuilder, false, false);
    }

    public void b(a eventBuilder) {
        a(eventBuilder, false, true);
    }

    public void c(a eventBuilder) {
        a(eventBuilder, true, false);
    }

    public void a(anl analyticsSettingsData, String protocolAndHostOverride) {
        b(new ro$1(this, analyticsSettingsData, protocolAndHostOverride));
    }

    public void a() {
        b(new ro$2(this));
    }

    public void a(String rolledOverFile) {
        b(new ro$3(this));
    }

    public void b() {
        b(new ro$4(this));
    }

    public void c() {
        b(new ro$5(this));
    }

    void a(a eventBuilder, boolean sync, boolean flush) {
        Runnable runnable = new ro$6(this, eventBuilder, flush);
        if (sync) {
            a(runnable);
        } else {
            b(runnable);
        }
    }

    private void a(Runnable runnable) {
        try {
            this.a.submit(runnable).get();
        } catch (Exception e) {
            akx.h().e("Answers", "Failed to run events task", e);
        }
    }

    private void b(Runnable runnable) {
        try {
            this.a.submit(runnable);
        } catch (Exception e) {
            akx.h().e("Answers", "Failed to submit events task", e);
        }
    }
}
