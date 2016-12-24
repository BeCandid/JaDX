package defpackage;

import android.content.Context;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.measurement.AppMeasurement.a;
import com.google.android.gms.measurement.internal.zzw;
import java.io.IOException;
import java.util.Map;

public class ahj extends agd {
    private final Map<String, Map<String, String>> a = new dh();
    private final Map<String, Map<String, Boolean>> b = new dh();
    private final Map<String, Map<String, Boolean>> c = new dh();
    private final Map<String, abz$b> d = new dh();
    private final Map<String, String> e = new dh();

    ahj(ahk ahk) {
        super(ahk);
    }

    private abz$b a(String str, byte[] bArr) {
        if (bArr == null) {
            return new abz$b();
        }
        aas a = aas.a(bArr);
        abz$b abz_b = new abz$b();
        try {
            abz$b abz_b2 = (abz$b) abz_b.a(a);
            w().E().a("Parsed config. version, gmp_app_id", abz_b.b, abz_b.c);
            return abz_b;
        } catch (IOException e) {
            w().z().a("Unable to merge remote config", str, e);
            return null;
        }
    }

    private Map<String, String> a(abz$b abz_b) {
        Map<String, String> dhVar = new dh();
        if (!(abz_b == null || abz_b.e == null)) {
            for (abz$c abz_c : abz_b.e) {
                if (abz_c != null) {
                    dhVar.put(abz_c.b, abz_c.c);
                }
            }
        }
        return dhVar;
    }

    private void a(String str, abz$b abz_b) {
        Map dhVar = new dh();
        Map dhVar2 = new dh();
        if (!(abz_b == null || abz_b.f == null)) {
            for (abz$a abz_a : abz_b.f) {
                if (abz_a != null) {
                    String str2 = (String) a.a.get(abz_a.b);
                    if (str2 != null) {
                        abz_a.b = str2;
                    }
                    dhVar.put(abz_a.b, abz_a.c);
                    dhVar2.put(abz_a.b, abz_a.d);
                }
            }
        }
        this.b.put(str, dhVar);
        this.c.put(str, dhVar2);
    }

    private void d(String str) {
        c();
        j();
        xz.a(str);
        if (!this.d.containsKey(str)) {
            byte[] d = r().d(str);
            if (d == null) {
                this.a.put(str, null);
                this.b.put(str, null);
                this.c.put(str, null);
                this.d.put(str, null);
                this.e.put(str, null);
                return;
            }
            abz$b a = a(str, d);
            this.a.put(str, a(a));
            a(str, a);
            this.d.put(str, a);
            this.e.put(str, null);
        }
    }

    protected abz$b a(String str) {
        c();
        j();
        xz.a(str);
        d(str);
        return (abz$b) this.d.get(str);
    }

    String a(String str, String str2) {
        j();
        d(str);
        Map map = (Map) this.a.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    protected boolean a(String str, byte[] bArr, String str2) {
        c();
        j();
        xz.a(str);
        abz$b a = a(str, bArr);
        if (a == null) {
            return false;
        }
        a(str, a);
        this.d.put(str, a);
        this.e.put(str, str2);
        this.a.put(str, a(a));
        k().a(str, a.g);
        try {
            a.g = null;
            byte[] bArr2 = new byte[a.b()];
            a.a(zzamc.a(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            w().z().a("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        r().a(str, bArr);
        return true;
    }

    protected String b(String str) {
        j();
        return (String) this.e.get(str);
    }

    boolean b(String str, String str2) {
        j();
        d(str);
        Map map = (Map) this.b.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected void c(String str) {
        j();
        this.e.put(str, null);
    }

    boolean c(String str, String str2) {
        j();
        d(str);
        Map map = (Map) this.c.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected void e() {
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
