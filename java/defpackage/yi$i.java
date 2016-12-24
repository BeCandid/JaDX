package defpackage;

import com.google.android.gms.common.ConnectionResult;

public class yi$i implements yi$f {
    final /* synthetic */ yi a;

    public yi$i(yi yiVar) {
        this.a = yiVar;
    }

    public void a(ConnectionResult connectionResult) {
        if (connectionResult.b()) {
            this.a.a(null, this.a.u());
        } else if (this.a.v != null) {
            this.a.v.a(connectionResult);
        }
    }
}
