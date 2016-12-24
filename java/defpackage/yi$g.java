package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class yi$g extends yw$a {
    private yi a;
    private final int b;

    public yi$g(yi yiVar, int i) {
        this.a = yiVar;
        this.b = i;
    }

    private void a() {
        this.a = null;
    }

    public void a(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public void a(int i, IBinder iBinder, Bundle bundle) {
        xz.a(this.a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
        this.a.a(i, iBinder, bundle, this.b);
        a();
    }
}
