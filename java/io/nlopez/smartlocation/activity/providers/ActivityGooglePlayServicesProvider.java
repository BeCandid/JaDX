package io.nlopez.smartlocation.activity.providers;

import android.app.Activity;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import defpackage.acf;
import defpackage.aoi;
import defpackage.aom;
import defpackage.aon;
import defpackage.aor;
import defpackage.aos;
import defpackage.xh;
import defpackage.xh$b;
import defpackage.xh$c;
import defpackage.xl;

public class ActivityGooglePlayServicesProvider implements xh$b, xh$c, xl<Status> {
    private static final String a = (ActivityGooglePlayServicesProvider.class.getCanonicalName() + ".DETECTED_ACTIVITY");
    private xh b;
    private aos c;
    private aoi d;
    private aom e;
    private Context f;
    private boolean g;
    private boolean h;
    private PendingIntent i;
    private aon j;
    private final aor k;
    private BroadcastReceiver l;

    public static class ActivityRecognitionService extends IntentService {
        public ActivityRecognitionService() {
            super(ActivityRecognitionService.class.getSimpleName());
        }

        protected void onHandleIntent(Intent intent) {
            if (ActivityRecognitionResult.a(intent)) {
                DetectedActivity mostProbableActivity = ActivityRecognitionResult.b(intent).a();
                Intent activityIntent = new Intent(ActivityGooglePlayServicesProvider.a);
                activityIntent.putExtra("activity", mostProbableActivity);
                sendBroadcast(activityIntent);
            }
        }
    }

    public ActivityGooglePlayServicesProvider() {
        this(null);
    }

    public ActivityGooglePlayServicesProvider(aor playServicesListener) {
        this.g = false;
        this.h = false;
        this.l = new BroadcastReceiver(this) {
            final /* synthetic */ ActivityGooglePlayServicesProvider a;

            {
                this.a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                if (ActivityGooglePlayServicesProvider.a.equals(intent.getAction()) && intent.hasExtra("activity")) {
                    this.a.c.a("sending new activity", new Object[0]);
                    this.a.a((DetectedActivity) intent.getParcelableExtra("activity"));
                }
            }
        };
        this.k = playServicesListener;
    }

    private void a(aon params) {
        if (this.b.a()) {
            this.i = PendingIntent.getService(this.f, 0, new Intent(this.f, ActivityRecognitionService.class), 134217728);
            acf.b.a(this.b, params.a(), this.i).a(this);
        }
    }

    public void a(Bundle bundle) {
        this.c.a("onConnected", new Object[0]);
        if (this.g) {
            a(this.j);
        }
        if (this.k != null) {
            this.k.a(bundle);
        }
    }

    public void a(int i) {
        this.c.a("onConnectionSuspended " + i, new Object[0]);
        if (this.k != null) {
            this.k.a(i);
        }
    }

    public void a(ConnectionResult connectionResult) {
        this.c.a("onConnectionFailed", new Object[0]);
        if (this.k != null) {
            this.k.a(connectionResult);
        }
    }

    private void a(DetectedActivity detectedActivity) {
        if (this.d != null) {
            this.d.a(detectedActivity);
        }
        if (this.e != null) {
            this.e.a("GMS", detectedActivity);
        }
    }

    public void a(Status status) {
        if (status.f()) {
            this.c.a("Activity update request successful", new Object[0]);
        } else if (status.e() && (this.f instanceof Activity)) {
            this.c.b("Unable to register, but we can solve this - will startActivityForResult expecting result code 10002 (if received, please try again)", new Object[0]);
            try {
                status.a((Activity) this.f, 10002);
            } catch (SendIntentException e) {
                this.c.a(e, "problem with startResolutionForResult", new Object[0]);
            }
        } else {
            this.c.c("Registering failed: " + status.c(), new Object[0]);
        }
    }
}
