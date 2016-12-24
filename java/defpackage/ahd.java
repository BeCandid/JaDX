package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzw;

public class ahd extends agd {
    private final String a = y().a();
    private final char b;
    private final long c = y().N();
    private final ahd$a d;
    private final ahd$a e;
    private final ahd$a f;
    private final ahd$a g;
    private final ahd$a h;
    private final ahd$a i;
    private final ahd$a j;
    private final ahd$a k;
    private final ahd$a l;

    ahd(ahk ahk) {
        super(ahk);
        if (y().P()) {
            this.b = y().O() ? 'P' : 'C';
        } else {
            this.b = y().O() ? 'p' : 'c';
        }
        this.d = new ahd$a(this, 6, false, false);
        this.e = new ahd$a(this, 6, true, false);
        this.f = new ahd$a(this, 6, false, true);
        this.g = new ahd$a(this, 5, false, false);
        this.h = new ahd$a(this, 5, true, false);
        this.i = new ahd$a(this, 5, false, true);
        this.j = new ahd$a(this, 4, false, false);
        this.k = new ahd$a(this, 3, false, false);
        this.l = new ahd$a(this, 2, false, false);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    static String a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String a = ahd.a(AppMeasurement.class.getCanonicalName());
                String a2 = ahd.a(ahk.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = ahd.a(className);
                            if (className.equals(a) || className.equals(a2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    static String a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object a = ahd.a(z, obj);
        Object a2 = ahd.a(z, obj2);
        Object a3 = ahd.a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    public ahd$a A() {
        return this.h;
    }

    public ahd$a B() {
        return this.i;
    }

    public ahd$a C() {
        return this.j;
    }

    public ahd$a D() {
        return this.k;
    }

    public ahd$a E() {
        return this.l;
    }

    public String F() {
        Pair a = x().b.a();
        if (a == null || a == ahh.a) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(a.second));
        String str = (String) a.first;
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    protected void a(int i, String str) {
        Log.println(i, this.a, str);
    }

    public void a(int i, String str, Object obj, Object obj2, Object obj3) {
        xz.a((Object) str);
        zzw k = this.n.k();
        if (k == null) {
            a(6, "Scheduler not set. Not logging error/warn.");
        } else if (!k.a()) {
            a(6, "Scheduler not initialized. Not logging error/warn.");
        } else if (k.b()) {
            a(6, "Scheduler shutdown. Not logging error/warn.");
        } else {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String valueOf = String.valueOf("1");
            char charAt = "01VDIWEA?".charAt(i);
            char c = this.b;
            long j = this.c;
            String valueOf2 = String.valueOf(ahd.a(true, str, obj, obj2, obj3));
            valueOf = new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
            if (valueOf.length() > 1024) {
                valueOf = str.substring(0, 1024);
            }
            k.a(new ahd$1(this, valueOf));
        }
    }

    protected void a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && a(i)) {
            a(i, ahd.a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            a(i, str, obj, obj2, obj3);
        }
    }

    protected boolean a(int i) {
        return Log.isLoggable(this.a, i);
    }

    protected void e() {
    }

    public ahd$a f() {
        return this.d;
    }

    public ahd$a g() {
        return this.e;
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

    public ahd$a z() {
        return this.g;
    }
}
