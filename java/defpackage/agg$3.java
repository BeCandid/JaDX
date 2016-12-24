package defpackage;

import android.os.RemoteException;

class agg$3 implements Runnable {
    final /* synthetic */ agg a;

    agg$3(agg agg) {
        this.a = agg;
    }

    public void run() {
        aha c = this.a.b;
        if (c == null) {
            this.a.w().f().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            c.b(this.a.m().a(this.a.w().F()));
            this.a.D();
        } catch (RemoteException e) {
            this.a.w().f().a("Failed to send measurementEnabled to AppMeasurementService", e);
        }
    }
}
