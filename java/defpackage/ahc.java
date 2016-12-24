package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class ahc extends yi<aha> {
    public ahc(Context context, Looper looper, yi$b yi_b, yi$c yi_c) {
        super(context, looper, 93, yi_b, yi_c, null);
    }

    public /* synthetic */ IInterface a(IBinder iBinder) {
        return b(iBinder);
    }

    public aha b(IBinder iBinder) {
        return aha$a.a(iBinder);
    }

    protected String f() {
        return "com.google.android.gms.measurement.START";
    }

    protected String g() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
