package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AbstractCheckForUpdatesController */
abstract class sl implements su {
    private final AtomicBoolean a;
    private final AtomicBoolean b;
    private Context c;
    private sn d;
    private IdManager e;
    private anp f;
    private so g;
    private ani h;
    private alu i;
    private anb j;
    private long k;

    public sl() {
        this(false);
    }

    public sl(boolean externallyReady) {
        this.a = new AtomicBoolean();
        this.k = 0;
        this.b = new AtomicBoolean(externallyReady);
    }

    public void a(Context context, sn beta, IdManager idManager, anp betaSettings, so buildProps, ani preferenceStore, alu currentTimeProvider, anb httpRequestFactory) {
        this.c = context;
        this.d = beta;
        this.e = idManager;
        this.f = betaSettings;
        this.g = buildProps;
        this.h = preferenceStore;
        this.i = currentTimeProvider;
        this.j = httpRequestFactory;
        if (b()) {
            c();
        }
    }

    protected boolean a() {
        this.b.set(true);
        return this.a.get();
    }

    boolean b() {
        this.a.set(true);
        return this.b.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void c() {
        synchronized (this.h) {
            if (this.h.a().contains("last_update_check")) {
                this.h.a(this.h.b().remove("last_update_check"));
            }
        }
        long currentTimeMillis = this.i.a();
        long updateCheckDelayMillis = ((long) this.f.b) * 1000;
        akx.h().a("Beta", "Check for updates delay: " + updateCheckDelayMillis);
        akx.h().a("Beta", "Check for updates last check time: " + d());
        long nextCheckTimeMillis = d() + updateCheckDelayMillis;
        akx.h().a("Beta", "Check for updates current time: " + currentTimeMillis + ", next check time: " + nextCheckTimeMillis);
        if (currentTimeMillis >= nextCheckTimeMillis) {
            try {
                e();
            } finally {
                a(currentTimeMillis);
            }
        } else {
            akx.h().a("Beta", "Check for updates next check time was not passed");
        }
    }

    private void e() {
        akx.h().a("Beta", "Performing update check");
        new sp(this.d, this.d.g(), this.f.a, this.j, new sr()).a(new alr().a(this.c), (String) this.e.i().get(DeviceIdentifierType.c), this.g);
    }

    void a(long time) {
        this.k = time;
    }

    long d() {
        return this.k;
    }
}
