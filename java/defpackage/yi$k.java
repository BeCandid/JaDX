package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public final class yi$k extends yi$a {
    final /* synthetic */ yi e;

    public yi$k(yi yiVar, int i, Bundle bundle) {
        this.e = yiVar;
        super(yiVar, i, bundle);
    }

    protected void a(ConnectionResult connectionResult) {
        this.e.p.a(connectionResult);
        this.e.a(connectionResult);
    }

    protected boolean a() {
        this.e.p.a(ConnectionResult.a);
        return true;
    }
}
