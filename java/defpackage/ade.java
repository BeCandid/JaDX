package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class ade {
    private static boolean a = false;

    public static synchronized int a(Context context) {
        int i = 0;
        synchronized (ade.class) {
            za.zzb(context, "Context is null");
            if (!a) {
                try {
                    ade.a(ady.a(context));
                    a = true;
                } catch (GooglePlayServicesNotAvailableException e) {
                    i = e.a;
                }
            }
        }
        return i;
    }

    public static void a(aea aea) {
        try {
            adc.a(aea.a());
            aez.a(aea.b());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
