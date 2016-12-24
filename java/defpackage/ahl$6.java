package defpackage;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

class ahl$6 implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ UserAttributeParcel b;
    final /* synthetic */ ahl c;

    ahl$6(ahl ahl, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.c = ahl;
        this.a = appMetadata;
        this.b = userAttributeParcel;
    }

    public void run() {
        this.c.a.J();
        this.c.a(this.a.h);
        this.c.a.a(this.b, this.a);
    }
}
