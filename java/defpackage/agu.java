package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.measurement.internal.zzw;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class agu extends agd {
    private long a;
    private String b;
    private Boolean c;

    agu(ahk ahk) {
        super(ahk);
    }

    public String A() {
        c();
        return this.b;
    }

    public boolean a(Context context) {
        if (this.c == null) {
            if (y().O()) {
                this.c = Boolean.valueOf(true);
            } else {
                this.c = Boolean.valueOf(false);
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        packageManager.getPackageInfo(aac.GOOGLE_PLAY_SERVICES_PACKAGE, 128);
                        this.c = Boolean.valueOf(true);
                    }
                } catch (NameNotFoundException e) {
                }
            }
        }
        return this.c.booleanValue();
    }

    protected void e() {
        Calendar instance = Calendar.getInstance();
        this.a = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String valueOf = String.valueOf(locale.getLanguage().toLowerCase(Locale.ENGLISH));
        String valueOf2 = String.valueOf(locale.getCountry().toLowerCase(Locale.ENGLISH));
        this.b = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("-").append(valueOf2).toString();
    }

    public String f() {
        c();
        return Build.MODEL;
    }

    public String g() {
        c();
        return VERSION.RELEASE;
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

    public long z() {
        c();
        return this.a;
    }
}
