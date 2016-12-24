package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.SessionEvent;
import com.crashlytics.android.answers.SessionEvent.Type;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: SessionAnalyticsManager */
class sf implements rt$a {
    final ro a;
    final akv b;
    final rt c;
    final rr d;
    private final long e;

    public static sf a(alc kit, Context context, IdManager idManager, String versionCode, String versionName, long installedAt) {
        sj metadataCollector = new sj(context, idManager, versionCode, versionName);
        rp filesManagerProvider = new rp(context, new anh(kit));
        ana httpRequestFactory = new ana(akx.h());
        akv lifecycleManager = new akv(context);
        ScheduledExecutorService executorService = alw.b("Answers Events Handler");
        rt backgroundManager = new rt(executorService);
        return new sf(new ro(kit, context, filesManagerProvider, metadataCollector, httpRequestFactory, executorService), lifecycleManager, backgroundManager, rr.a(context), installedAt);
    }

    sf(ro eventsHandler, akv lifecycleManager, rt backgroundManager, rr preferenceManager, long installedAt) {
        this.a = eventsHandler;
        this.b = lifecycleManager;
        this.c = backgroundManager;
        this.d = preferenceManager;
        this.e = installedAt;
    }

    public void b() {
        this.a.b();
        this.b.a(new rq(this, this.c));
        this.c.a((rt$a) this);
        if (a(this.e)) {
            d();
            this.d.a();
        }
    }

    public void c() {
        this.b.a();
        this.a.a();
    }

    public void a(ru event) {
        akx.h().a("Answers", "Logged custom event: " + event);
        this.a.a(SessionEvent.a(event));
    }

    public void a(rz event) {
        akx.h().a("Answers", "Logged predefined event: " + event);
        this.a.a(SessionEvent.a(event));
    }

    public void a(String sessionId, String exceptionName) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        akx.h().a("Answers", "Logged crash");
        this.a.c(SessionEvent.a(sessionId, exceptionName));
    }

    public void a(String sessionId) {
    }

    public void d() {
        akx.h().a("Answers", "Logged install");
        this.a.b(SessionEvent.a());
    }

    public void a(Activity activity, Type type) {
        akx.h().a("Answers", "Logged lifecycle event: " + type.name());
        this.a.a(SessionEvent.a(type, activity));
    }

    public void a() {
        akx.h().a("Answers", "Flush events when app is backgrounded");
        this.a.c();
    }

    public void a(anl analyticsSettingsData, String protocolAndHostOverride) {
        this.c.a(analyticsSettingsData.h);
        this.a.a(analyticsSettingsData, protocolAndHostOverride);
    }

    boolean a(long installedAt) {
        return !this.d.b() && b(installedAt);
    }

    boolean b(long installedAt) {
        return System.currentTimeMillis() - installedAt < 3600000;
    }
}
