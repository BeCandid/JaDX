package defpackage;

import android.os.RemoteException;

class agg$6 implements Runnable {
    final /* synthetic */ agg a;

    agg$6(agg agg) {
        this.a = agg;
    }

    public void run() {
        aha c = this.a.b;
        if (c == null) {
            this.a.w().f().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            c.a(this.a.m().a(this.a.w().F()));
            this.a.D();
        } catch (RemoteException e) {
            this.a.w().f().a("Failed to send app launch to AppMeasurementService", e);
        }
    }
}
