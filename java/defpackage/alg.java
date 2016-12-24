package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: Onboarding */
class alg extends alc<Boolean> {
    private final anb a = new ana();
    private PackageManager b;
    private String c;
    private PackageInfo d;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private final Future<Map<String, ale>> p;
    private final Collection<alc> q;

    protected /* synthetic */ Object f() {
        return c();
    }

    public alg(Future<Map<String, ale>> kitsFinder, Collection<alc> providedKits) {
        this.p = kitsFinder;
        this.q = providedKits;
    }

    public String a() {
        return "1.3.12.127";
    }

    protected boolean a_() {
        try {
            this.m = D().j();
            this.b = E().getPackageManager();
            this.c = E().getPackageName();
            this.d = this.b.getPackageInfo(this.c, 0);
            this.k = Integer.toString(this.d.versionCode);
            this.l = this.d.versionName == null ? "0.0" : this.d.versionName;
            this.n = this.b.getApplicationLabel(E().getApplicationInfo()).toString();
            this.o = Integer.toString(E().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (NameNotFoundException e) {
            akx.h().e("Fabric", "Failed init", e);
            return false;
        }
    }

    protected Boolean c() {
        String iconHash = CommonUtils.k(E());
        boolean appConfigured = false;
        aoc settingsData = g();
        if (settingsData != null) {
            try {
                Map scannedKits;
                if (this.p != null) {
                    scannedKits = (Map) this.p.get();
                } else {
                    scannedKits = new HashMap();
                }
                appConfigured = a(iconHash, settingsData.a, a(scannedKits, this.q).values());
            } catch (Exception e) {
                akx.h().e("Fabric", "Error performing auto configuration.", e);
            }
        }
        return Boolean.valueOf(appConfigured);
    }

    private aoc g() {
        try {
            aoa.a().a(this, this.i, this.a, this.k, this.l, e()).c();
            return aoa.a().b();
        } catch (Exception e) {
            akx.h().e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, ale> a(Map<String, ale> scannedKits, Collection<alc> providedKits) {
        for (alc kit : providedKits) {
            if (!scannedKits.containsKey(kit.b())) {
                scannedKits.put(kit.b(), new ale(kit.b(), kit.a(), "binary"));
            }
        }
        return scannedKits;
    }

    public String b() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean a(String iconHash, ano appSettings, Collection<ale> sdkKits) {
        if ("new".equals(appSettings.b)) {
            if (b(iconHash, appSettings, sdkKits)) {
                return aoa.a().d();
            }
            akx.h().e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(appSettings.b)) {
            return aoa.a().d();
        } else {
            if (!appSettings.e) {
                return true;
            }
            akx.h().a("Fabric", "Server says an update is required - forcing a full App update.");
            c(iconHash, appSettings, sdkKits);
            return true;
        }
    }

    private boolean b(String iconHash, ano appSettings, Collection<ale> sdkKits) {
        return new anr(this, e(), appSettings.c, this.a).a(a(anx.a(E(), iconHash), (Collection) sdkKits));
    }

    private boolean c(String iconHash, ano appSettings, Collection<ale> sdkKits) {
        return a(appSettings, anx.a(E(), iconHash), (Collection) sdkKits);
    }

    private boolean a(ano appSettings, anx iconRequest, Collection<ale> sdkKits) {
        return new aoh(this, e(), appSettings.c, this.a).a(a(iconRequest, (Collection) sdkKits));
    }

    private ann a(anx iconRequest, Collection<ale> sdkKits) {
        return new ann(new alr().a(E()), D().c(), this.l, this.k, CommonUtils.a(new String[]{CommonUtils.m(context)}), this.n, DeliveryMechanism.a(this.m).a(), this.o, "0", iconRequest, sdkKits);
    }

    String e() {
        return CommonUtils.b(E(), "com.crashlytics.ApiEndpoint");
    }
}
