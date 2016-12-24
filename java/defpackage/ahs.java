package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class ahs extends yp<ahq> implements acc {
    private final boolean d;
    private final yl e;
    private final Bundle f;
    private Integer g;

    public ahs(Context context, Looper looper, boolean z, yl ylVar, acd acd, xh$b xh_b, xh$c xh_c) {
        this(context, looper, z, ylVar, ahs.a(ylVar), xh_b, xh_c);
    }

    public ahs(Context context, Looper looper, boolean z, yl ylVar, Bundle bundle, xh$b xh_b, xh$c xh_c) {
        super(context, looper, 44, ylVar, xh_b, xh_c);
        this.d = z;
        this.e = ylVar;
        this.f = bundle;
        this.g = ylVar.f();
    }

    public static Bundle a(yl ylVar) {
        acd e = ylVar.e();
        Integer f = ylVar.f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", ylVar.a());
        if (f != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", f.intValue());
        }
        if (e != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", e.a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", e.b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", e.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", e.d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", e.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", e.f());
        }
        return bundle;
    }

    protected /* synthetic */ IInterface a(IBinder iBinder) {
        return b(iBinder);
    }

    protected ahq b(IBinder iBinder) {
        return ahq$a.a(iBinder);
    }

    protected String f() {
        return "com.google.android.gms.signin.service.START";
    }

    protected String g() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected Bundle o() {
        if (!l().getPackageName().equals(this.e.c())) {
            this.f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.e.c());
        }
        return this.f;
    }

    public boolean s() {
        return this.d;
    }
}
