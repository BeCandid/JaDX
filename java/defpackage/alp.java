package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;

/* compiled from: AdvertisingInfoServiceStrategy */
class alp implements alq {
    private final Context a;

    public alp(Context context) {
        this.a = context.getApplicationContext();
    }

    public alm a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            akx.h().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.a.getPackageManager().getPackageInfo(aac.GOOGLE_PLAY_STORE_PACKAGE, 0);
            alp$a connection = new alp$a(null);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage(aac.GOOGLE_PLAY_SERVICES_PACKAGE);
            try {
                if (this.a.bindService(intent, connection, 1)) {
                    alp$b adInterface = new alp$b(connection.a());
                    alm alm = new alm(adInterface.a(), adInterface.b());
                    this.a.unbindService(connection);
                    return alm;
                }
                akx.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                return null;
            } catch (Exception e) {
                akx.h().d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                this.a.unbindService(connection);
                return null;
            } catch (Throwable t) {
                akx.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", t);
                return null;
            }
        } catch (NameNotFoundException e2) {
            akx.h().a("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Throwable e3) {
            akx.h().a("Fabric", "Unable to determine if Google Play Services is available", e3);
            return null;
        }
    }
}
