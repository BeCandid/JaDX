package defpackage;

import android.content.Intent;
import java.util.UUID;

/* compiled from: AppCall */
public class vf {
    private static vf a;
    private UUID b;
    private Intent c;
    private int d;

    public static vf a() {
        return a;
    }

    public static synchronized vf a(UUID callId, int requestCode) {
        vf pendingCall;
        synchronized (vf.class) {
            pendingCall = vf.a();
            if (pendingCall != null && pendingCall.c().equals(callId) && pendingCall.d() == requestCode) {
                vf.a(null);
            } else {
                pendingCall = null;
            }
        }
        return pendingCall;
    }

    private static synchronized boolean a(vf appCall) {
        boolean z;
        synchronized (vf.class) {
            vf oldAppCall = vf.a();
            a = appCall;
            z = oldAppCall != null;
        }
        return z;
    }

    public vf(int requestCode) {
        this(requestCode, UUID.randomUUID());
    }

    public vf(int requestCode, UUID callId) {
        this.b = callId;
        this.d = requestCode;
    }

    public Intent b() {
        return this.c;
    }

    public UUID c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public void a(Intent requestIntent) {
        this.c = requestIntent;
    }

    public boolean e() {
        return vf.a(this);
    }
}
