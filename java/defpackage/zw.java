package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public final class zw {
    public static boolean a(Context context, int i) {
        boolean z = false;
        if (!zw.a(context, i, aac.GOOGLE_PLAY_SERVICES_PACKAGE)) {
            return z;
        }
        try {
            return aad.a(context).a(context.getPackageManager(), context.getPackageManager().getPackageInfo(aac.GOOGLE_PLAY_SERVICES_PACKAGE, 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return z;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean a(Context context, int i, String str) {
        return abv.b(context).a(i, str);
    }
}
