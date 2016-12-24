package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zq {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;

    @TargetApi(20)
    public static boolean a(Context context) {
        if (c == null) {
            boolean z = zt.g() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            c = Boolean.valueOf(z);
        }
        return c.booleanValue();
    }

    public static boolean a(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (a == null) {
            boolean z2 = (resources.getConfiguration().screenLayout & 15) > 3;
            if ((zt.a() && z2) || zq.b(resources)) {
                z = true;
            }
            a = Boolean.valueOf(z);
        }
        return a.booleanValue();
    }

    @TargetApi(13)
    private static boolean b(Resources resources) {
        if (b == null) {
            Configuration configuration = resources.getConfiguration();
            boolean z = zt.b() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
            b = Boolean.valueOf(z);
        }
        return b.booleanValue();
    }
}
