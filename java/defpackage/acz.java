package defpackage;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.internal.PlaceImpl;

abstract class acz {
    public static acu c(Context context, Intent intent) {
        za.zzb(intent, "intent must not be null");
        za.zzb(context, "context must not be null");
        return (acu) xx.a(intent, "selected_place", PlaceImpl.CREATOR);
    }

    public static Status d(Context context, Intent intent) {
        za.zzb(intent, "intent must not be null");
        za.zzb(context, "context must not be null");
        return (Status) xx.a(intent, "status", Status.CREATOR);
    }
}
