package defpackage;

import com.google.android.gms.measurement.internal.AppMetadata;
import java.util.List;
import java.util.concurrent.Callable;

class ahl$7 implements Callable<List<agn>> {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ ahl b;

    ahl$7(ahl ahl, AppMetadata appMetadata) {
        this.b = ahl;
        this.a = appMetadata;
    }

    public List<agn> a() throws Exception {
        this.b.a.J();
        return this.b.a.o().a(this.a.b);
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }
}
