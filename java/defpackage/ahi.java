package defpackage;

import android.content.Context;
import android.content.Intent;

public final class ahi {
    static final Object a = new Object();
    static ace b;
    static Boolean c;

    public static boolean a(Context context) {
        xz.a((Object) context);
        if (c != null) {
            return c.booleanValue();
        }
        boolean a = ago.a(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
        c = Boolean.valueOf(a);
        return a;
    }

    public void a(Context context, Intent intent) {
        ahk a = ahk.a(context);
        ahd f = a.f();
        if (intent == null) {
            f.z().a("AppMeasurementReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (a.d().O()) {
            f.E().a("Device AppMeasurementReceiver got", action);
        } else {
            f.E().a("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean a2 = agh.a(context);
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (a) {
                context.startService(className);
                if (a2) {
                    try {
                        if (b == null) {
                            b = new ace(context, 1, "AppMeasurement WakeLock");
                            b.a(false);
                        }
                        b.a(1000);
                    } catch (SecurityException e) {
                        f.z().a("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                    return;
                }
            }
        }
    }
}
