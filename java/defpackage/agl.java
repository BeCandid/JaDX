package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzw;

public class agl extends agd {
    private boolean a;
    private final AlarmManager b = ((AlarmManager) q().getSystemService("alarm"));

    protected agl(ahk ahk) {
        super(ahk);
    }

    private PendingIntent g() {
        Intent className = new Intent().setClassName(q(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(q(), 0, className, 0);
    }

    public void a(long j) {
        c();
        xz.b(j > 0);
        xz.a(ahi.a(q()), (Object) "Receiver not registered/enabled");
        xz.a(agh.a(q()), (Object) "Service not registered/enabled");
        f();
        long b = p().b() + j;
        this.a = true;
        this.b.setInexactRepeating(2, b, Math.max(y().ad(), j), g());
    }

    protected void e() {
        this.b.cancel(g());
    }

    public void f() {
        c();
        this.a = false;
        this.b.cancel(g());
    }

    public /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public /* bridge */ /* synthetic */ agq k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ agf l() {
        return super.l();
    }

    public /* bridge */ /* synthetic */ ahb m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ agu n() {
        return super.n();
    }

    public /* bridge */ /* synthetic */ agg o() {
        return super.o();
    }

    public /* bridge */ /* synthetic */ zn p() {
        return super.p();
    }

    public /* bridge */ /* synthetic */ Context q() {
        return super.q();
    }

    public /* bridge */ /* synthetic */ ags r() {
        return super.r();
    }

    public /* bridge */ /* synthetic */ ago s() {
        return super.s();
    }

    public /* bridge */ /* synthetic */ ahj t() {
        return super.t();
    }

    public /* bridge */ /* synthetic */ agi u() {
        return super.u();
    }

    public /* bridge */ /* synthetic */ zzw v() {
        return super.v();
    }

    public /* bridge */ /* synthetic */ ahd w() {
        return super.w();
    }

    public /* bridge */ /* synthetic */ ahh x() {
        return super.x();
    }

    public /* bridge */ /* synthetic */ agr y() {
        return super.y();
    }
}
