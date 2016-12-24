package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzw;

public class agr extends ahm {
    static final String a = String.valueOf(aaa.b / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean b;

    agr(ahk ahk) {
        super(ahk);
    }

    private Boolean g(String str) {
        Boolean bool = null;
        xz.a(str);
        try {
            PackageManager packageManager = q().getPackageManager();
            if (packageManager == null) {
                w().f().a("Failed to load metadata: PackageManager is null");
            } else {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(q().getPackageName(), 128);
                if (applicationInfo == null) {
                    w().f().a("Failed to load metadata: ApplicationInfo is null");
                } else if (applicationInfo.metaData == null) {
                    w().f().a("Failed to load metadata: Metadata bundle is null");
                } else if (applicationInfo.metaData.containsKey(str)) {
                    bool = Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                }
            }
        } catch (NameNotFoundException e) {
            w().f().a("Failed to load metadata: Package name not found", e);
        }
        return bool;
    }

    public int A() {
        return 2048;
    }

    int B() {
        return 500;
    }

    public long C() {
        return (long) ((Integer) agz.m.b()).intValue();
    }

    public long D() {
        return (long) ((Integer) agz.n.b()).intValue();
    }

    public long E() {
        return 1000;
    }

    int F() {
        return 25;
    }

    int G() {
        return 50;
    }

    long H() {
        return 3600000;
    }

    long I() {
        return 60000;
    }

    long J() {
        return 61000;
    }

    long K() {
        return ((Long) agz.A.b()).longValue();
    }

    public String L() {
        return "google_app_measurement.db";
    }

    public String M() {
        return "google_app_measurement2.db";
    }

    public long N() {
        return 9080;
    }

    public boolean O() {
        return false;
    }

    public boolean P() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    ApplicationInfo applicationInfo = q().getApplicationInfo();
                    String b = zu.b();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(b);
                        this.b = Boolean.valueOf(z);
                    }
                    if (this.b == null) {
                        this.b = Boolean.TRUE;
                        w().f().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.b.booleanValue();
    }

    public boolean Q() {
        if (O()) {
            return false;
        }
        Boolean g = g("firebase_analytics_collection_deactivated");
        return (g == null || g.booleanValue()) ? false : true;
    }

    public Boolean R() {
        return O() ? null : g("firebase_analytics_collection_enabled");
    }

    public boolean S() {
        return abh.b();
    }

    public long T() {
        return ((Long) agz.y.b()).longValue();
    }

    public long U() {
        return ((Long) agz.u.b()).longValue();
    }

    public long V() {
        return 1000;
    }

    public long W() {
        return Math.max(0, ((Long) agz.e.b()).longValue());
    }

    public int X() {
        return Math.max(0, ((Integer) agz.k.b()).intValue());
    }

    public int Y() {
        return Math.max(1, ((Integer) agz.l.b()).intValue());
    }

    public String Z() {
        return (String) agz.q.b();
    }

    public int a(String str) {
        return b(str, agz.o);
    }

    public long a(String str, agz$a<Long> agz_a_java_lang_Long) {
        if (str == null) {
            return ((Long) agz_a_java_lang_Long.b()).longValue();
        }
        Object a = t().a(str, agz_a_java_lang_Long.a());
        if (TextUtils.isEmpty(a)) {
            return ((Long) agz_a_java_lang_Long.b()).longValue();
        }
        try {
            return ((Long) agz_a_java_lang_Long.a(Long.valueOf(Long.valueOf(a).longValue()))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) agz_a_java_lang_Long.b()).longValue();
        }
    }

    String a() {
        return (String) agz.c.b();
    }

    public String a(String str, String str2) {
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) agz.g.b()).encodedAuthority((String) agz.h.b());
        String str3 = "config/app/";
        String valueOf = String.valueOf(str);
        encodedAuthority.path(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3)).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(N()));
        return builder.build().toString();
    }

    public long aa() {
        return ((Long) agz.f.b()).longValue();
    }

    public long ab() {
        return Math.max(0, ((Long) agz.r.b()).longValue());
    }

    public long ac() {
        return Math.max(0, ((Long) agz.t.b()).longValue());
    }

    public long ad() {
        return ((Long) agz.s.b()).longValue();
    }

    public long ae() {
        return Math.max(0, ((Long) agz.v.b()).longValue());
    }

    public long af() {
        return Math.max(0, ((Long) agz.w.b()).longValue());
    }

    public int ag() {
        return Math.min(20, Math.max(0, ((Integer) agz.x.b()).intValue()));
    }

    public int b() {
        return 25;
    }

    public int b(String str, agz$a<Integer> agz_a_java_lang_Integer) {
        if (str == null) {
            return ((Integer) agz_a_java_lang_Integer.b()).intValue();
        }
        Object a = t().a(str, agz_a_java_lang_Integer.a());
        if (TextUtils.isEmpty(a)) {
            return ((Integer) agz_a_java_lang_Integer.b()).intValue();
        }
        try {
            return ((Integer) agz_a_java_lang_Integer.a(Integer.valueOf(Integer.valueOf(a).intValue()))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) agz_a_java_lang_Integer.b()).intValue();
        }
    }

    long b(String str) {
        return a(str, agz.d);
    }

    public int c() {
        return 32;
    }

    int c(String str) {
        return b(str, agz.z);
    }

    public int d() {
        return 24;
    }

    public int d(String str) {
        return b(str, agz.i);
    }

    int e() {
        return 24;
    }

    public int e(String str) {
        return Math.max(0, b(str, agz.j));
    }

    int f() {
        return 36;
    }

    public int f(String str) {
        return Math.max(0, Math.min(1000000, b(str, agz.p)));
    }

    int g() {
        return 256;
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

    public int z() {
        return 36;
    }
}
