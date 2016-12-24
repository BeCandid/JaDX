package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

/* compiled from: AdvertisingInfoProvider */
public class aln {
    private final Context a;
    private final ani b;

    public aln(Context context) {
        this.a = context.getApplicationContext();
        this.b = new anj(context, "TwitterAdvertisingInfoPreferences");
    }

    public alm a() {
        alm infoToReturn = b();
        if (c(infoToReturn)) {
            akx.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            a(infoToReturn);
            return infoToReturn;
        }
        infoToReturn = e();
        b(infoToReturn);
        return infoToReturn;
    }

    private void a(alm advertisingInfo) {
        new Thread(new aln$1(this, advertisingInfo)).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void b(alm infoToReturn) {
        if (c(infoToReturn)) {
            this.b.a(this.b.b().putString("advertising_id", infoToReturn.a).putBoolean("limit_ad_tracking_enabled", infoToReturn.b));
        } else {
            this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected alm b() {
        return new alm(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public alq c() {
        return new alo(this.a);
    }

    public alq d() {
        return new alp(this.a);
    }

    private boolean c(alm advertisingInfo) {
        return (advertisingInfo == null || TextUtils.isEmpty(advertisingInfo.a)) ? false : true;
    }

    private alm e() {
        alm infoToReturn = c().a();
        if (c(infoToReturn)) {
            akx.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            infoToReturn = d().a();
            if (c(infoToReturn)) {
                akx.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                akx.h().a("Fabric", "AdvertisingInfo not present");
            }
        }
        return infoToReturn;
    }
}
