package defpackage;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

class abg$d implements yi$f {
    final /* synthetic */ abg a;
    private final xf$f b;
    private final aba<?> c;

    public abg$d(abg abg, xf$f xf_f, aba<?> aba_) {
        this.a = abg;
        this.b = xf_f;
        this.c = aba_;
    }

    public void a(ConnectionResult connectionResult) {
        if (connectionResult.b()) {
            this.b.a(null, Collections.emptySet());
        } else {
            ((abg$c) this.a.j.get(this.c)).a(connectionResult);
        }
    }
}
