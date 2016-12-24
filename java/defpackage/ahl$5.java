package defpackage;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

class ahl$5 implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ UserAttributeParcel b;
    final /* synthetic */ ahl c;

    ahl$5(ahl ahl, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.c = ahl;
        this.a = appMetadata;
        this.b = userAttributeParcel;
    }

    public void run() {
        this.c.a.J();
        this.c.a(this.a.h);
        this.c.a.b(this.b, this.a);
    }
}
