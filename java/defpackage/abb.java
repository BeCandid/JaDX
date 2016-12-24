package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.Set;

public final class abb extends abe<xq> {
    private int d;
    private boolean e;

    private void a(ConnectionResult connectionResult) {
        dh dhVar = null;
        for (int i = 0; i < dhVar.size(); i++) {
            a((aba) dhVar.b(i), connectionResult);
        }
    }

    protected xq a(Status status) {
        xq xqVar;
        synchronized (null) {
            try {
                a(new ConnectionResult(8));
                dh dhVar = null;
                if (dhVar.size() != 1) {
                    xqVar = new xq(status, null);
                }
            } finally {
            }
        }
        return xqVar;
    }

    public void a(aba<?> aba_, ConnectionResult connectionResult) {
        synchronized (null) {
            dh dhVar = null;
            try {
                dhVar.put(aba_, connectionResult);
                this.d--;
                boolean b = connectionResult.b();
                if (!b) {
                    this.e = b;
                }
                if (this.d == 0) {
                    Status status = this.e ? new Status(13) : Status.a;
                    dhVar = null;
                    b(dhVar.size() == 1 ? new xp(status, null) : new xq(status, null));
                }
            } finally {
            }
        }
    }

    public Set<aba<?>> b() {
        dh dhVar = null;
        return dhVar.keySet();
    }

    protected /* synthetic */ xk b(Status status) {
        return a(status);
    }
}
