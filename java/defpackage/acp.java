package defpackage;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;

public class acp implements acg {
    public xi<Status> a(xh client, long detectionIntervalMillis, PendingIntent callbackIntent) {
        return client.zzb(new acp$1(this, client, detectionIntervalMillis, callbackIntent));
    }
}
