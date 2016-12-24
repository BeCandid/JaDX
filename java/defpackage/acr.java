package defpackage;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.a;
import java.util.List;

public class acr implements acl {
    public xi<Status> a(xh client, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return client.zzb(new acr$1(this, client, geofencingRequest, pendingIntent));
    }

    public xi<Status> a(xh client, List<String> geofenceRequestIds) {
        return client.zzb(new acr$2(this, client, geofenceRequestIds));
    }

    @Deprecated
    public xi<Status> a(xh client, List<ack> geofences, PendingIntent pendingIntent) {
        a aVar = new a();
        aVar.a(geofences);
        aVar.a(5);
        return a(client, aVar.a(), pendingIntent);
    }
}
