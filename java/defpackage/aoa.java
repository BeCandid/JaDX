package defpackage;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Settings */
public class aoa {
    private final AtomicReference<aoc> a;
    private final CountDownLatch b;
    private aob c;
    private boolean d;

    public static aoa a() {
        return aoa$a.a;
    }

    private aoa() {
        this.a = new AtomicReference();
        this.b = new CountDownLatch(1);
        this.d = false;
    }

    public synchronized aoa a(alc kit, IdManager idManager, anb httpRequestFactory, String versionCode, String versionName, String urlEndpoint) {
        aoa this;
        if (this.d) {
            this = this;
        } else {
            if (this.c == null) {
                Context context = kit.E();
                String appIdentifier = idManager.c();
                String apiKey = new alr().a(context);
                String installerPackageName = idManager.j();
                alu currentTimeProvider = new ama();
                aoe settingsJsonTransform = new anu();
                anq ans = new ans(kit);
                String iconHash = CommonUtils.k(context);
                this.c = new ant(kit, new aof(apiKey, idManager.g(), idManager.f(), idManager.e(), idManager.m(), idManager.b(), idManager.n(), CommonUtils.a(new String[]{CommonUtils.m(context)}), versionName, versionCode, DeliveryMechanism.a(installerPackageName).a(), iconHash), currentTimeProvider, settingsJsonTransform, ans, new anv(kit, urlEndpoint, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{appIdentifier}), httpRequestFactory));
            }
            this.d = true;
            this = this;
        }
        return this;
    }

    public <T> T a(aoa$b<T> access, T defaultValue) {
        aoc settingsData = (aoc) this.a.get();
        return settingsData == null ? defaultValue : access.b(settingsData);
    }

    public aoc b() {
        try {
            this.b.await();
            return (aoc) this.a.get();
        } catch (InterruptedException e) {
            akx.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean c() {
        aoc settingsData;
        settingsData = this.c.a();
        a(settingsData);
        return settingsData != null;
    }

    public synchronized boolean d() {
        aoc settingsData;
        settingsData = this.c.a(SettingsCacheBehavior.b);
        a(settingsData);
        if (settingsData == null) {
            akx.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return settingsData != null;
    }

    private void a(aoc settingsData) {
        this.a.set(settingsData);
        this.b.countDown();
    }
}
