package defpackage;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;

class ahl$2 implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ EventParcel b;
    final /* synthetic */ ahl c;

    ahl$2(ahl ahl, AppMetadata appMetadata, EventParcel eventParcel) {
        this.c = ahl;
        this.a = appMetadata;
        this.b = eventParcel;
    }

    public void run() {
        this.c.a.J();
        this.c.a(this.a.h);
        this.c.a.a(this.b, this.a);
    }
}
