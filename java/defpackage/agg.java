package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public class agg extends agd {
    private final agg$a a;
    private aha b;
    private Boolean c;
    private final agt d;
    private final agk e;
    private final List<Runnable> f = new ArrayList();
    private final agt g;

    protected agg(ahk ahk) {
        super(ahk);
        this.e = new agk(ahk.r());
        this.a = new agg$a(this);
        this.d = new agg$1(this, ahk);
        this.g = new agg$2(this, ahk);
    }

    private void D() {
        j();
        this.e.a();
        if (!this.n.C()) {
            this.d.a(y().K());
        }
    }

    private boolean E() {
        List queryIntentServices = q().getPackageManager().queryIntentServices(new Intent().setClassName(q(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    private void F() {
        j();
        if (f()) {
            w().E().a("Inactivity, disconnecting from AppMeasurementService");
            C();
        }
    }

    private void G() {
        j();
        A();
    }

    private void H() {
        j();
        w().E().a("Processing queued up service tasks", Integer.valueOf(this.f.size()));
        for (Runnable a : this.f) {
            v().a(a);
        }
        this.f.clear();
        this.g.c();
    }

    private void a(aha aha) {
        j();
        xz.a((Object) aha);
        this.b = aha;
        D();
        H();
    }

    private void a(ComponentName componentName) {
        j();
        if (this.b != null) {
            this.b = null;
            w().E().a("Disconnected from device MeasurementService", componentName);
            G();
        }
    }

    private void a(Runnable runnable) throws IllegalStateException {
        j();
        if (f()) {
            runnable.run();
        } else if (((long) this.f.size()) >= y().V()) {
            w().f().a("Discarding data. Max runnable queue size reached");
        } else {
            this.f.add(runnable);
            if (!this.n.C()) {
                this.g.a(60000);
            }
            A();
        }
    }

    void A() {
        j();
        c();
        if (!f()) {
            if (this.c == null) {
                this.c = x().B();
                if (this.c == null) {
                    w().E().a("State of service unknown");
                    this.c = Boolean.valueOf(B());
                    x().a(this.c.booleanValue());
                }
            }
            if (this.c.booleanValue()) {
                w().E().a("Using measurement service");
                this.a.a();
            } else if (!this.n.C() && E()) {
                w().E().a("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(q(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.a.a(intent);
            } else if (y().P()) {
                w().E().a("Using direct local measurement implementation");
                a(new ahl(this.n, true));
            } else {
                w().f().a("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    protected boolean B() {
        j();
        c();
        if (y().O()) {
            return true;
        }
        w().E().a("Checking service availability");
        switch (aaa.b().a(q())) {
            case uu$h.com_facebook_login_view_com_facebook_confirm_logout /*0*/:
                w().E().a("Service available");
                return true;
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                w().E().a("Service missing");
                return false;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                w().D().a("Service container out of date");
                return true;
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                w().z().a("Service disabled");
                return false;
            case uu$h.CardView_contentPaddingLeft /*9*/:
                w().z().a("Service invalid");
                return false;
            case ha$a.Toolbar_collapseIcon /*18*/:
                w().z().a("Service updating");
                return true;
            default:
                return false;
        }
    }

    public void C() {
        j();
        c();
        try {
            ze.a().a(q(), this.a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.b = null;
    }

    protected void a(EventParcel eventParcel, String str) {
        xz.a((Object) eventParcel);
        j();
        c();
        a(new agg$4(this, str, eventParcel));
    }

    protected void a(UserAttributeParcel userAttributeParcel) {
        j();
        c();
        a(new agg$5(this, userAttributeParcel));
    }

    protected void e() {
    }

    public boolean f() {
        j();
        c();
        return this.b != null;
    }

    protected void g() {
        j();
        c();
        a(new agg$3(this));
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

    protected void z() {
        j();
        c();
        a(new agg$6(this));
    }
}
