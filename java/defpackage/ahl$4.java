package defpackage;

import com.google.android.gms.measurement.internal.EventParcel;
import java.util.concurrent.Callable;

class ahl$4 implements Callable<byte[]> {
    final /* synthetic */ EventParcel a;
    final /* synthetic */ String b;
    final /* synthetic */ ahl c;

    ahl$4(ahl ahl, EventParcel eventParcel, String str) {
        this.c = ahl;
        this.a = eventParcel;
        this.b = str;
    }

    public byte[] a() throws Exception {
        this.c.a.J();
        return this.c.a.b(this.a, this.b);
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }
}
