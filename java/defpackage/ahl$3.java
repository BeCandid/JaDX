package defpackage;

import com.google.android.gms.measurement.internal.EventParcel;

class ahl$3 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ EventParcel b;
    final /* synthetic */ String c;
    final /* synthetic */ ahl d;

    ahl$3(ahl ahl, String str, EventParcel eventParcel, String str2) {
        this.d = ahl;
        this.a = str;
        this.b = eventParcel;
        this.c = str2;
    }

    public void run() {
        this.d.a.J();
        this.d.a(this.a);
        this.d.a.a(this.b, this.c);
    }
}
