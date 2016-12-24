package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzw;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ahk {
    private static volatile ahk b;
    private List<Long> A;
    private int B;
    private int C;
    public final ahx a = new ahx(this);
    private final Context c;
    private final agr d;
    private final ahh e;
    private final ahd f;
    private final zzw g;
    private final agi h;
    private final ahj i;
    private final AppMeasurement j;
    private final ago k;
    private final ags l;
    private final ahe m;
    private final zn n;
    private final agg o;
    private final agu p;
    private final agf q;
    private final ahb r;
    private final ahf s;
    private final agl t;
    private final agq u;
    private final boolean v;
    private boolean w;
    private Boolean x;
    private FileLock y;
    private FileChannel z;

    ahk(age age) {
        xz.a((Object) age);
        this.c = age.a;
        this.n = age.l(this);
        this.d = age.a(this);
        ahh b = age.b(this);
        b.d();
        this.e = b;
        ahd c = age.c(this);
        c.d();
        this.f = c;
        f().C().a("App measurement is starting up, version", Long.valueOf(d().N()));
        f().C().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        f().D().a("Debug logging enabled");
        f().D().a("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
        this.k = age.i(this);
        agu n = age.n(this);
        n.d();
        this.p = n;
        ahb o = age.o(this);
        o.d();
        this.r = o;
        ags j = age.j(this);
        j.d();
        this.l = j;
        agq r = age.r(this);
        r.d();
        this.u = r;
        ahe k = age.k(this);
        k.d();
        this.m = k;
        agg m = age.m(this);
        m.d();
        this.o = m;
        agf h = age.h(this);
        h.d();
        this.q = h;
        agl q = age.q(this);
        q.d();
        this.t = q;
        this.s = age.p(this);
        this.j = age.g(this);
        agi e = age.e(this);
        e.d();
        this.h = e;
        ahj f = age.f(this);
        f.d();
        this.i = f;
        zzw d = age.d(this);
        d.d();
        this.g = d;
        if (this.B != this.C) {
            f().f().a("Not all components initialized", Integer.valueOf(this.B), Integer.valueOf(this.C));
        }
        this.v = true;
        if (!(this.d.O() || C())) {
            if (!(this.c.getApplicationContext() instanceof Application)) {
                f().z().a("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                l().f();
            } else {
                f().D().a("Not tracking deep linking pre-ICS");
            }
        }
        this.g.a(new ahk$1(this));
    }

    private boolean L() {
        y();
        return this.A != null;
    }

    private boolean M() {
        y();
        a();
        return o().H() || !TextUtils.isEmpty(o().C());
    }

    private void N() {
        y();
        a();
        if (!K()) {
            return;
        }
        if (b() && M()) {
            long O = O();
            if (O == 0) {
                v().b();
                w().f();
                return;
            } else if (p().f()) {
                long a = e().e.a();
                long ab = d().ab();
                if (!n().a(a, ab)) {
                    O = Math.max(O, a + ab);
                }
                v().b();
                O -= r().a();
                if (O <= 0) {
                    w().a(1);
                    return;
                }
                f().E().a("Upload scheduled in approximately ms", Long.valueOf(O));
                w().a(O);
                return;
            } else {
                v().a();
                w().f();
                return;
            }
        }
        v().b();
        w().f();
    }

    private long O() {
        long a = r().a();
        long ae = d().ae();
        long ac = d().ac();
        long a2 = e().c.a();
        long a3 = e().d.a();
        long max = Math.max(o().F(), o().G());
        if (max == 0) {
            return 0;
        }
        max = a - Math.abs(max - a);
        a3 = a - Math.abs(a3 - a);
        a = Math.max(a - Math.abs(a2 - a), a3);
        ae += max;
        if (!n().a(a, ac)) {
            ae = a + ac;
        }
        if (a3 == 0 || a3 < max) {
            return ae;
        }
        for (int i = 0; i < d().ag(); i++) {
            ae += ((long) (1 << i)) * d().af();
            if (ae > a3) {
                return ae;
            }
        }
        return 0;
    }

    public static ahk a(Context context) {
        xz.a((Object) context);
        xz.a(context.getApplicationContext());
        if (b == null) {
            synchronized (ahk.class) {
                if (b == null) {
                    b = new age(context).a();
                }
            }
        }
        return b;
    }

    private void a(int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        y();
        a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.A;
        this.A = null;
        if ((i == 200 || i == 204) && th == null) {
            e().c.a(r().a());
            e().d.a(0);
            N();
            f().E().a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            o().f();
            try {
                for (Long longValue : list) {
                    o().a(longValue.longValue());
                }
                o().g();
                if (p().f() && M()) {
                    H();
                } else {
                    N();
                }
            } finally {
                o().z();
            }
        } else {
            f().E().a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            e().d.a(r().a());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                e().e.a(r().a());
            }
            N();
        }
    }

    private void a(ahm ahm) {
        if (ahm == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private void a(List<Long> list) {
        xz.b(!list.isEmpty());
        if (this.A != null) {
            f().f().a("Set uploading progress before finishing the previous upload");
        } else {
            this.A = new ArrayList(list);
        }
    }

    private boolean a(String str, long j) {
        o().f();
        try {
            ahk ahk = this;
            ags$b ahk_a = new ahk$a();
            o().a(str, j, ahk_a);
            if (ahk_a.a()) {
                o().g();
                o().z();
                return false;
            }
            int i;
            aca$e aca_e = ahk_a.a;
            aca_e.c = new aca$b[ahk_a.c.size()];
            int i2 = 0;
            int i3 = 0;
            while (i3 < ahk_a.c.size()) {
                if (j().b(ahk_a.a.p, ((aca$b) ahk_a.c.get(i3)).c)) {
                    f().z().a("Dropping blacklisted raw event", ((aca$b) ahk_a.c.get(i3)).c);
                    n().a(11, "_ev", ((aca$b) ahk_a.c.get(i3)).c);
                    i = i2;
                } else {
                    int i4;
                    if (j().c(ahk_a.a.p, ((aca$b) ahk_a.c.get(i3)).c)) {
                        int i5;
                        Object obj;
                        aca$c aca_c;
                        if (((aca$b) ahk_a.c.get(i3)).b == null) {
                            ((aca$b) ahk_a.c.get(i3)).b = new aca$c[0];
                        }
                        for (aca$c aca_c2 : ((aca$b) ahk_a.c.get(i3)).b) {
                            if ("_c".equals(aca_c2.b)) {
                                aca_c2.d = Long.valueOf(1);
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            f().E().a("Marking event as conversion", ((aca$b) ahk_a.c.get(i3)).c);
                            aca$c[] aca_cArr = (aca$c[]) Arrays.copyOf(((aca$b) ahk_a.c.get(i3)).b, ((aca$b) ahk_a.c.get(i3)).b.length + 1);
                            aca_c = new aca$c();
                            aca_c.b = "_c";
                            aca_c.d = Long.valueOf(1);
                            aca_cArr[aca_cArr.length - 1] = aca_c;
                            ((aca$b) ahk_a.c.get(i3)).b = aca_cArr;
                        }
                        boolean a = ago.a(((aca$b) ahk_a.c.get(i3)).c);
                        if (a && o().a(E(), ahk_a.a.p, false, a, false).c - ((long) d().a(ahk_a.a.p)) > 0) {
                            f().z().a("Too many conversions. Not logging as conversion.");
                            aca$b aca_b = (aca$b) ahk_a.c.get(i3);
                            Object obj2 = null;
                            aca$c aca_c3 = null;
                            aca$c[] aca_cArr2 = ((aca$b) ahk_a.c.get(i3)).b;
                            int length = aca_cArr2.length;
                            int i6 = 0;
                            while (i6 < length) {
                                Object obj3;
                                aca_c = aca_cArr2[i6];
                                if ("_c".equals(aca_c.b)) {
                                    obj3 = obj2;
                                } else if ("_err".equals(aca_c.b)) {
                                    aca$c aca_c4 = aca_c3;
                                    int i7 = 1;
                                    aca_c = aca_c4;
                                } else {
                                    aca_c = aca_c3;
                                    obj3 = obj2;
                                }
                                i6++;
                                obj2 = obj3;
                                aca_c3 = aca_c;
                            }
                            if (obj2 != null && aca_c3 != null) {
                                aca$c[] aca_cArr3 = new aca$c[(aca_b.b.length - 1)];
                                i4 = 0;
                                aca_cArr2 = aca_b.b;
                                length = aca_cArr2.length;
                                i5 = 0;
                                while (i5 < length) {
                                    aca$c aca_c5 = aca_cArr2[i5];
                                    if (aca_c5 != aca_c3) {
                                        i = i4 + 1;
                                        aca_cArr3[i4] = aca_c5;
                                    } else {
                                        i = i4;
                                    }
                                    i5++;
                                    i4 = i;
                                }
                                ((aca$b) ahk_a.c.get(i3)).b = aca_cArr3;
                            } else if (aca_c3 != null) {
                                aca_c3.b = "_err";
                                aca_c3.d = Long.valueOf(10);
                            } else {
                                f().f().a("Did not find conversion parameter. Error not tracked");
                            }
                        }
                    }
                    i4 = i2 + 1;
                    aca_e.c[i2] = (aca$b) ahk_a.c.get(i3);
                    i = i4;
                }
                i3++;
                i2 = i;
            }
            if (i2 < ahk_a.c.size()) {
                aca_e.c = (aca$b[]) Arrays.copyOf(aca_e.c, i2);
            }
            aca_e.B = a(ahk_a.a.p, ahk_a.a.d, aca_e.c);
            aca_e.f = aca_e.c[0].d;
            aca_e.g = aca_e.c[0].d;
            for (i = 1; i < aca_e.c.length; i++) {
                aca$b aca_b2 = aca_e.c[i];
                if (aca_b2.d.longValue() < aca_e.f.longValue()) {
                    aca_e.f = aca_b2.d;
                }
                if (aca_b2.d.longValue() > aca_e.g.longValue()) {
                    aca_e.g = aca_b2.d;
                }
            }
            String str2 = ahk_a.a.p;
            agc b = o().b(str2);
            if (b == null) {
                f().f().a("Bundling raw events w/o app info");
            } else {
                long h = b.h();
                aca_e.i = h != 0 ? Long.valueOf(h) : null;
                long g = b.g();
                if (g != 0) {
                    h = g;
                }
                aca_e.h = h != 0 ? Long.valueOf(h) : null;
                b.r();
                aca_e.x = Integer.valueOf((int) b.o());
                b.a(aca_e.f.longValue());
                b.b(aca_e.g.longValue());
                o().a(b);
            }
            aca_e.y = f().F();
            o().a(aca_e);
            o().a(ahk_a.b);
            o().h(str2);
            o().g();
            return true;
        } finally {
            o().z();
        }
    }

    private aca$a[] a(String str, aca$g[] aca_gArr, aca$b[] aca_bArr) {
        xz.a(str);
        return x().a(str, aca_bArr, aca_gArr);
    }

    private void b(agd agd) {
        if (agd == null) {
            throw new IllegalStateException("Component not created");
        } else if (!agd.a()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void c(AppMetadata appMetadata) {
        Object obj = 1;
        y();
        a();
        xz.a((Object) appMetadata);
        xz.a(appMetadata.b);
        agc b = o().b(appMetadata.b);
        String b2 = e().b(appMetadata.b);
        Object obj2 = null;
        if (b == null) {
            agc agc = new agc(this, appMetadata.b);
            agc.a(e().f());
            agc.c(b2);
            b = agc;
            obj2 = 1;
        } else if (!b2.equals(b.e())) {
            b.c(b2);
            b.a(e().f());
            int i = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.c) || appMetadata.c.equals(b.d()))) {
            b.b(appMetadata.c);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.l) || appMetadata.l.equals(b.f()))) {
            b.d(appMetadata.l);
            obj2 = 1;
        }
        if (!(appMetadata.f == 0 || appMetadata.f == b.l())) {
            b.d(appMetadata.f);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.d) || appMetadata.d.equals(b.i()))) {
            b.e(appMetadata.d);
            obj2 = 1;
        }
        if (appMetadata.k != b.j()) {
            b.c(appMetadata.k);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.e) || appMetadata.e.equals(b.k()))) {
            b.f(appMetadata.e);
            obj2 = 1;
        }
        if (appMetadata.g != b.m()) {
            b.e(appMetadata.g);
            obj2 = 1;
        }
        if (appMetadata.i != b.n()) {
            b.a(appMetadata.i);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            o().a(b);
        }
    }

    void A() {
        y();
        a();
        if (K() && B()) {
            a(a(z()), u().A());
        }
    }

    boolean B() {
        y();
        try {
            this.z = new RandomAccessFile(new File(q().getFilesDir(), this.l.B()), "rw").getChannel();
            this.y = this.z.tryLock();
            if (this.y != null) {
                f().E().a("Storage concurrent access okay");
                return true;
            }
            f().f().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            f().f().a("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            f().f().a("Failed to access storage lock file", e2);
        }
    }

    protected boolean C() {
        return false;
    }

    public boolean D() {
        boolean z = false;
        y();
        a();
        if (d().Q()) {
            return false;
        }
        Boolean R = d().R();
        if (R != null) {
            z = R.booleanValue();
        } else if (!d().S()) {
            z = true;
        }
        return e().c(z);
    }

    long E() {
        return ((((r().a() + e().z()) / 1000) / 60) / 60) / 24;
    }

    void F() {
        if (d().O()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    void G() {
        if (!d().O()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    public void H() {
        Map map = null;
        int i = 0;
        y();
        a();
        if (!d().O()) {
            Boolean B = e().B();
            if (B == null) {
                f().z().a("Upload data called on the client side before use of service was decided");
                return;
            } else if (B.booleanValue()) {
                f().f().a("Upload called in the client side when service should be used");
                return;
            }
        }
        if (L()) {
            f().z().a("Uploading requested multiple times");
        } else if (p().f()) {
            long a = r().a();
            a(a - d().aa());
            long a2 = e().c.a();
            if (a2 != 0) {
                f().D().a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(a - a2)));
            }
            String C = o().C();
            if (TextUtils.isEmpty(C)) {
                String b = o().b(a - d().aa());
                if (!TextUtils.isEmpty(b)) {
                    agc b2 = o().b(b);
                    if (b2 != null) {
                        String a3 = d().a(b2.d(), b2.c());
                        try {
                            URL url = new URL(a3);
                            f().E().a("Fetching remote configuration", b2.b());
                            abz$b a4 = j().a(b2.b());
                            CharSequence b3 = j().b(b2.b());
                            if (!(a4 == null || TextUtils.isEmpty(b3))) {
                                map = new dh();
                                map.put("If-Modified-Since", b3);
                            }
                            p().a(b, url, map, new ahk$3(this));
                            return;
                        } catch (MalformedURLException e) {
                            f().f().a("Failed to parse config URL. Not fetching", a3);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            List<Pair> a5 = o().a(C, d().d(C), d().e(C));
            if (!a5.isEmpty()) {
                aca$e aca_e;
                Object obj;
                List subList;
                for (Pair pair : a5) {
                    aca_e = (aca$e) pair.first;
                    if (!TextUtils.isEmpty(aca_e.t)) {
                        obj = aca_e.t;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    for (int i2 = 0; i2 < a5.size(); i2++) {
                        aca_e = (aca$e) ((Pair) a5.get(i2)).first;
                        if (!TextUtils.isEmpty(aca_e.t) && !aca_e.t.equals(obj)) {
                            subList = a5.subList(0, i2);
                            break;
                        }
                    }
                }
                subList = a5;
                aca$d aca_d = new aca$d();
                aca_d.b = new aca$e[subList.size()];
                List arrayList = new ArrayList(subList.size());
                while (i < aca_d.b.length) {
                    aca_d.b[i] = (aca$e) ((Pair) subList.get(i)).first;
                    arrayList.add((Long) ((Pair) subList.get(i)).second);
                    aca_d.b[i].s = Long.valueOf(d().N());
                    aca_d.b[i].e = Long.valueOf(a);
                    aca_d.b[i].A = Boolean.valueOf(d().O());
                    i++;
                }
                Object b4 = f().a(2) ? ago.b(aca_d) : null;
                byte[] a6 = n().a(aca_d);
                String Z = d().Z();
                try {
                    URL url2 = new URL(Z);
                    a(arrayList);
                    e().d.a(a);
                    Object obj2 = "?";
                    if (aca_d.b.length > 0) {
                        obj2 = aca_d.b[0].p;
                    }
                    f().E().a("Uploading data. app, uncompressed size, data", obj2, Integer.valueOf(a6.length), b4);
                    p().a(C, url2, a6, null, new ahk$2(this));
                } catch (MalformedURLException e2) {
                    f().f().a("Failed to parse upload URL. Not uploading", Z);
                }
            }
        } else {
            f().z().a("Network not connected, ignoring upload request");
            N();
        }
    }

    void I() {
        this.C++;
    }

    void J() {
        y();
        a();
        if (!this.w) {
            f().C().a("This instance being marked as an uploader");
            A();
        }
        this.w = true;
    }

    boolean K() {
        y();
        a();
        return this.w || C();
    }

    int a(FileChannel fileChannel) {
        int i = 0;
        y();
        if (fileChannel == null || !fileChannel.isOpen()) {
            f().f().a("Bad chanel to read from");
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0);
                int read = fileChannel.read(allocate);
                if (read != 4) {
                    f().z().a("Unexpected data length or empty data in channel. Bytes read", Integer.valueOf(read));
                } else {
                    allocate.flip();
                    i = allocate.getInt();
                }
            } catch (IOException e) {
                f().f().a("Failed to read from channel", e);
            }
        }
        return i;
    }

    void a() {
        if (!this.v) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    void a(agd agd) {
        this.B++;
    }

    void a(agv agv, AppMetadata appMetadata) {
        y();
        a();
        xz.a((Object) agv);
        xz.a((Object) appMetadata);
        xz.a(agv.a);
        xz.b(agv.a.equals(appMetadata.b));
        aca$e aca_e = new aca$e();
        aca_e.b = Integer.valueOf(1);
        aca_e.j = "android";
        aca_e.p = appMetadata.b;
        aca_e.o = appMetadata.e;
        aca_e.q = appMetadata.d;
        aca_e.D = Integer.valueOf((int) appMetadata.k);
        aca_e.r = Long.valueOf(appMetadata.f);
        aca_e.z = appMetadata.c;
        aca_e.w = appMetadata.g == 0 ? null : Long.valueOf(appMetadata.g);
        Pair a = e().a(appMetadata.b);
        if (a != null && !TextUtils.isEmpty((CharSequence) a.first)) {
            aca_e.t = (String) a.first;
            aca_e.u = (Boolean) a.second;
        } else if (!t().a(this.c)) {
            String string = Secure.getString(this.c.getContentResolver(), "android_id");
            if (string == null) {
                f().z().a("null secure ID");
                string = "null";
            } else if (string.isEmpty()) {
                f().z().a("empty secure ID");
            }
            aca_e.G = string;
        }
        aca_e.l = t().f();
        aca_e.k = t().g();
        aca_e.n = Integer.valueOf((int) t().z());
        aca_e.m = t().A();
        aca_e.s = null;
        aca_e.e = null;
        aca_e.f = null;
        aca_e.g = null;
        agc b = o().b(appMetadata.b);
        if (b == null) {
            b = new agc(this, appMetadata.b);
            b.a(e().f());
            b.d(appMetadata.l);
            b.b(appMetadata.c);
            b.c(e().b(appMetadata.b));
            b.f(0);
            b.a(0);
            b.b(0);
            b.e(appMetadata.d);
            b.c(appMetadata.k);
            b.f(appMetadata.e);
            b.d(appMetadata.f);
            b.e(appMetadata.g);
            b.a(appMetadata.i);
            o().a(b);
        }
        aca_e.v = b.c();
        aca_e.C = b.f();
        List a2 = o().a(appMetadata.b);
        aca_e.d = new aca$g[a2.size()];
        for (int i = 0; i < a2.size(); i++) {
            aca$g aca_g = new aca$g();
            aca_e.d[i] = aca_g;
            aca_g.c = ((agn) a2.get(i)).b;
            aca_g.b = Long.valueOf(((agn) a2.get(i)).c);
            n().a(aca_g, ((agn) a2.get(i)).d);
        }
        try {
            o().a(agv, o().b(aca_e));
        } catch (IOException e) {
            f().f().a("Data loss. Failed to insert raw event metadata", e);
        }
    }

    void a(AppMetadata appMetadata) {
        y();
        a();
        xz.a(appMetadata.b);
        c(appMetadata);
    }

    void a(AppMetadata appMetadata, long j) {
        agc b = o().b(appMetadata.b);
        if (!(b == null || b.d() == null || b.d().equals(appMetadata.c))) {
            f().z().a("New GMP App Id passed in. Removing cached database data.");
            o().g(b.b());
            b = null;
        }
        if (b != null && b.i() != null && !b.i().equals(appMetadata.d)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", b.i());
            a(new EventParcel("_au", new EventParams(bundle), "auto", j), appMetadata);
        }
    }

    void a(EventParcel eventParcel, AppMetadata appMetadata) {
        long nanoTime = System.nanoTime();
        y();
        a();
        String str = appMetadata.b;
        xz.a(str);
        if (!TextUtils.isEmpty(appMetadata.c)) {
            if (!appMetadata.i) {
                c(appMetadata);
            } else if (j().b(str, eventParcel.b)) {
                f().z().a("Dropping blacklisted event", eventParcel.b);
                n().a(11, "_ev", eventParcel.b);
            } else {
                if (f().a(2)) {
                    f().E().a("Logging event", eventParcel);
                }
                o().f();
                try {
                    Bundle b = eventParcel.c.b();
                    c(appMetadata);
                    if ("_iap".equals(eventParcel.b) || "ecommerce_purchase".equals(eventParcel.b)) {
                        long round;
                        Object string = b.getString("currency");
                        if ("ecommerce_purchase".equals(eventParcel.b)) {
                            double d = b.getDouble("value") * 1000000.0d;
                            if (d == 0.0d) {
                                d = ((double) b.getLong("value")) * 1000000.0d;
                            }
                            if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
                                f().z().a("Data lost. Currency value is too big", Double.valueOf(d));
                                o().g();
                                o().z();
                                return;
                            }
                            round = Math.round(d);
                        } else {
                            round = b.getLong("value");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            String toUpperCase = string.toUpperCase(Locale.US);
                            if (toUpperCase.matches("[A-Z]{3}")) {
                                agn agn;
                                String valueOf = String.valueOf("_ltv_");
                                toUpperCase = String.valueOf(toUpperCase);
                                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                                agn c = o().c(str, concat);
                                if (c == null || !(c.d instanceof Long)) {
                                    o().a(str, d().c(str) - 1);
                                    agn = new agn(str, concat, r().a(), Long.valueOf(round));
                                } else {
                                    agn = new agn(str, concat, r().a(), Long.valueOf(round + ((Long) c.d).longValue()));
                                }
                                if (!o().a(agn)) {
                                    f().f().a("Too many unique user properties are set. Ignoring user property.", agn.b, agn.d);
                                    n().a(9, null, null);
                                }
                            }
                        }
                    }
                    boolean a = ago.a(eventParcel.b);
                    ago.a(b);
                    boolean equals = "_err".equals(eventParcel.b);
                    ags$a a2 = o().a(E(), str, a, false, equals);
                    long C = a2.b - d().C();
                    if (C > 0) {
                        if (C % 1000 == 1) {
                            f().f().a("Data loss. Too many events logged. count", Long.valueOf(a2.b));
                        }
                        n().a(16, "_ev", eventParcel.b);
                        o().g();
                        return;
                    }
                    agw a3;
                    if (a) {
                        C = a2.a - d().D();
                        if (C > 0) {
                            if (C % 1000 == 1) {
                                f().f().a("Data loss. Too many public events logged. count", Long.valueOf(a2.a));
                            }
                            n().a(16, "_ev", eventParcel.b);
                            o().g();
                            o().z();
                            return;
                        }
                    }
                    if (equals) {
                        C = a2.d - d().E();
                        if (C > 0) {
                            if (C == 1) {
                                f().f().a("Too many error events logged. count", Long.valueOf(a2.d));
                            }
                            o().g();
                            o().z();
                            return;
                        }
                    }
                    n().a(b, "_o", eventParcel.d);
                    long c2 = o().c(str);
                    if (c2 > 0) {
                        f().z().a("Data lost. Too many events stored on disk, deleted", Long.valueOf(c2));
                    }
                    agv agv = new agv(this, eventParcel.d, str, eventParcel.b, eventParcel.e, 0, b);
                    agw a4 = o().a(str, agv.b);
                    if (a4 != null) {
                        agv = agv.a(this, a4.e);
                        a3 = a4.a(agv.d);
                    } else if (o().i(str) >= ((long) d().B())) {
                        f().f().a("Too many event names used, ignoring event. name, supported count", agv.b, Integer.valueOf(d().B()));
                        n().a(8, null, null);
                        o().z();
                        return;
                    } else {
                        a3 = new agw(str, agv.b, 0, 0, agv.d);
                    }
                    o().a(a3);
                    a(agv, appMetadata);
                    o().g();
                    if (f().a(2)) {
                        f().E().a("Event recorded", agv);
                    }
                    o().z();
                    N();
                    f().E().a("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } finally {
                    o().z();
                }
            }
        }
    }

    void a(EventParcel eventParcel, String str) {
        agc b = o().b(str);
        if (b == null || TextUtils.isEmpty(b.i())) {
            f().D().a("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = q().getPackageManager().getPackageInfo(str, 0).versionName;
            if (!(b.i() == null || b.i().equals(str2))) {
                f().z().a("App version does not match; dropping event", str);
                return;
            }
        } catch (NameNotFoundException e) {
            if (!"_ui".equals(eventParcel.b)) {
                f().z().a("Could not find package", str);
            }
        }
        EventParcel eventParcel2 = eventParcel;
        a(eventParcel2, new AppMetadata(str, b.d(), b.i(), b.j(), b.k(), b.l(), b.m(), null, b.n(), false, b.f()));
    }

    void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        y();
        a();
        if (!TextUtils.isEmpty(appMetadata.c)) {
            if (appMetadata.i) {
                int c = n().c(userAttributeParcel.b);
                if (c != 0) {
                    n().a(c, "_ev", n().a(userAttributeParcel.b, d().d(), true));
                    return;
                }
                c = n().c(userAttributeParcel.b, userAttributeParcel.a());
                if (c != 0) {
                    n().a(c, "_ev", n().a(userAttributeParcel.b, d().d(), true));
                    return;
                }
                Object d = n().d(userAttributeParcel.b, userAttributeParcel.a());
                if (d != null) {
                    agn agn = new agn(appMetadata.b, userAttributeParcel.b, userAttributeParcel.c, d);
                    f().D().a("Setting user property", agn.b, d);
                    o().f();
                    try {
                        c(appMetadata);
                        boolean a = o().a(agn);
                        o().g();
                        if (a) {
                            f().D().a("User property set", agn.b, agn.d);
                        } else {
                            f().f().a("Too many unique user properties are set. Ignoring user property.", agn.b, agn.d);
                            n().a(9, null, null);
                        }
                        o().z();
                        return;
                    } catch (Throwable th) {
                        o().z();
                    }
                } else {
                    return;
                }
            }
            c(appMetadata);
        }
    }

    void a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        int i2 = 0;
        y();
        a();
        xz.a(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        o().f();
        try {
            agc b = o().b(str);
            int i3 = ((i == 200 || i == 204 || i == 304) && th == null) ? 1 : 0;
            if (b == null) {
                f().z().a("App does not exist in onConfigFetched", str);
            } else if (i3 != 0 || i == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (j().a(str) == null && !j().a(str, null, null)) {
                        o().z();
                        return;
                    }
                } else if (!j().a(str, bArr, str2)) {
                    o().z();
                    return;
                }
                b.g(r().a());
                o().a(b);
                if (i == 404) {
                    f().z().a("Config not found. Using empty config");
                } else {
                    f().E().a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (p().f() && M()) {
                    H();
                } else {
                    N();
                }
            } else {
                b.h(r().a());
                o().a(b);
                f().E().a("Fetching config failed. code, error", Integer.valueOf(i), th);
                j().c(str);
                e().d.a(r().a());
                if (i == 503 || i == 429) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    e().e.a(r().a());
                }
                N();
            }
            o().g();
        } finally {
            o().z();
        }
    }

    public void a(boolean z) {
        N();
    }

    boolean a(int i, int i2) {
        y();
        if (i > i2) {
            f().f().a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (a(i2, z())) {
                f().E().a("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                f().f().a("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }

    boolean a(int i, FileChannel fileChannel) {
        y();
        if (fileChannel == null || !fileChannel.isOpen()) {
            f().f().a("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            f().f().a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            f().f().a("Failed to write to channel", e);
            return false;
        }
    }

    boolean a(long j) {
        return a(null, j);
    }

    public void b(AppMetadata appMetadata) {
        y();
        a();
        xz.a((Object) appMetadata);
        xz.a(appMetadata.b);
        if (!TextUtils.isEmpty(appMetadata.c)) {
            if (appMetadata.i) {
                long a = r().a();
                o().f();
                try {
                    a(appMetadata, a);
                    c(appMetadata);
                    if (o().a(appMetadata.b, "_f") == null) {
                        a(new UserAttributeParcel("_fot", a, Long.valueOf((1 + (a / 3600000)) * 3600000), "auto"), appMetadata);
                        b(appMetadata, a);
                        c(appMetadata, a);
                    } else if (appMetadata.j) {
                        d(appMetadata, a);
                    }
                    o().g();
                } finally {
                    o().z();
                }
            } else {
                c(appMetadata);
            }
        }
    }

    void b(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        a(new EventParcel("_f", new EventParams(bundle), "auto", j), appMetadata);
    }

    void b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        y();
        a();
        if (!TextUtils.isEmpty(appMetadata.c)) {
            if (appMetadata.i) {
                f().D().a("Removing user property", userAttributeParcel.b);
                o().f();
                try {
                    c(appMetadata);
                    o().b(appMetadata.b, userAttributeParcel.b);
                    o().g();
                    f().D().a("User property removed", userAttributeParcel.b);
                } finally {
                    o().z();
                }
            } else {
                c(appMetadata);
            }
        }
    }

    protected boolean b() {
        a();
        y();
        if (this.x == null) {
            boolean z = n().i("android.permission.INTERNET") && n().i("android.permission.ACCESS_NETWORK_STATE") && ahi.a(q()) && agh.a(q());
            this.x = Boolean.valueOf(z);
            if (this.x.booleanValue() && !d().O()) {
                this.x = Boolean.valueOf(n().f(u().g()));
            }
        }
        return this.x.booleanValue();
    }

    public byte[] b(EventParcel eventParcel, String str) {
        a();
        y();
        G();
        xz.a((Object) eventParcel);
        xz.a(str);
        aca$d aca_d = new aca$d();
        o().f();
        try {
            agc b = o().b(str);
            byte[] bArr;
            if (b == null) {
                f().D().a("Log and bundle not available. package_name", str);
                bArr = new byte[0];
                return bArr;
            } else if (b.n()) {
                long j;
                aca$e aca_e = new aca$e();
                aca_d.b = new aca$e[]{aca_e};
                aca_e.b = Integer.valueOf(1);
                aca_e.j = "android";
                aca_e.p = b.b();
                aca_e.o = b.k();
                aca_e.q = b.i();
                aca_e.D = Integer.valueOf((int) b.j());
                aca_e.r = Long.valueOf(b.l());
                aca_e.z = b.d();
                aca_e.w = Long.valueOf(b.m());
                Pair a = e().a(b.b());
                if (!(a == null || TextUtils.isEmpty((CharSequence) a.first))) {
                    aca_e.t = (String) a.first;
                    aca_e.u = (Boolean) a.second;
                }
                aca_e.l = t().f();
                aca_e.k = t().g();
                aca_e.n = Integer.valueOf((int) t().z());
                aca_e.m = t().A();
                aca_e.v = b.c();
                aca_e.C = b.f();
                List a2 = o().a(b.b());
                aca_e.d = new aca$g[a2.size()];
                for (int i = 0; i < a2.size(); i++) {
                    aca$g aca_g = new aca$g();
                    aca_e.d[i] = aca_g;
                    aca_g.c = ((agn) a2.get(i)).b;
                    aca_g.b = Long.valueOf(((agn) a2.get(i)).c);
                    n().a(aca_g, ((agn) a2.get(i)).d);
                }
                Bundle b2 = eventParcel.c.b();
                if ("_iap".equals(eventParcel.b)) {
                    b2.putLong("_c", 1);
                }
                b2.putString("_o", eventParcel.d);
                agw a3 = o().a(str, eventParcel.b);
                if (a3 == null) {
                    o().a(new agw(str, eventParcel.b, 1, 0, eventParcel.e));
                    j = 0;
                } else {
                    j = a3.e;
                    o().a(a3.a(eventParcel.e).a());
                }
                agv agv = new agv(this, eventParcel.d, str, eventParcel.b, eventParcel.e, j, b2);
                aca$b aca_b = new aca$b();
                aca_e.c = new aca$b[]{aca_b};
                aca_b.d = Long.valueOf(agv.d);
                aca_b.c = agv.b;
                aca_b.e = Long.valueOf(agv.e);
                aca_b.b = new aca$c[agv.f.a()];
                Iterator it = agv.f.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    aca$c aca_c = new aca$c();
                    int i3 = i2 + 1;
                    aca_b.b[i2] = aca_c;
                    aca_c.b = str2;
                    n().a(aca_c, agv.f.a(str2));
                    i2 = i3;
                }
                aca_e.B = a(b.b(), aca_e.d, aca_e.c);
                aca_e.f = aca_b.d;
                aca_e.g = aca_b.d;
                long h = b.h();
                aca_e.i = h != 0 ? Long.valueOf(h) : null;
                long g = b.g();
                if (g != 0) {
                    h = g;
                }
                aca_e.h = h != 0 ? Long.valueOf(h) : null;
                b.r();
                aca_e.x = Integer.valueOf((int) b.o());
                aca_e.s = Long.valueOf(d().N());
                aca_e.e = Long.valueOf(r().a());
                aca_e.A = Boolean.TRUE;
                b.a(aca_e.f.longValue());
                b.b(aca_e.g.longValue());
                o().a(b);
                o().g();
                o().z();
                try {
                    bArr = new byte[aca_d.b()];
                    zzamc a4 = zzamc.a(bArr);
                    aca_d.a(a4);
                    a4.b();
                    return n().a(bArr);
                } catch (IOException e) {
                    f().f().a("Data loss. Failed to bundle and serialize", e);
                    return null;
                }
            } else {
                f().D().a("Log and bundle disabled. package_name", str);
                bArr = new byte[0];
                o().z();
                return bArr;
            }
        } finally {
            o().z();
        }
    }

    protected void c() {
        y();
        if (!C() || (this.g.a() && !this.g.b())) {
            o().D();
            if (b()) {
                if (!(d().O() || TextUtils.isEmpty(u().g()))) {
                    String A = e().A();
                    if (A == null) {
                        e().c(u().g());
                    } else if (!A.equals(u().g())) {
                        f().C().a("Rechecking which service to use due to a GMP App Id change");
                        e().C();
                        this.o.C();
                        this.o.A();
                        e().c(u().g());
                    }
                }
                if (!(d().O() || C() || TextUtils.isEmpty(u().g()))) {
                    l().g();
                }
            } else if (D()) {
                if (!n().i("android.permission.INTERNET")) {
                    f().f().a("App is missing INTERNET permission");
                }
                if (!n().i("android.permission.ACCESS_NETWORK_STATE")) {
                    f().f().a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!ahi.a(q())) {
                    f().f().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!agh.a(q())) {
                    f().f().a("AppMeasurementService not registered/enabled");
                }
                f().f().a("Uploading is not possible. App measurement disabled");
            }
            N();
            return;
        }
        f().f().a("Scheduler shutting down before Scion.start() called");
    }

    void c(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        a(new EventParcel("_e", new EventParams(bundle), "auto", j), appMetadata);
    }

    public agr d() {
        return this.d;
    }

    void d(AppMetadata appMetadata, long j) {
        a(new EventParcel("_cd", new EventParams(new Bundle()), "auto", j), appMetadata);
    }

    public ahh e() {
        a(this.e);
        return this.e;
    }

    public ahd f() {
        b(this.f);
        return this.f;
    }

    public ahd g() {
        return (this.f == null || !this.f.a()) ? null : this.f;
    }

    public zzw h() {
        b(this.g);
        return this.g;
    }

    public agi i() {
        b(this.h);
        return this.h;
    }

    public ahj j() {
        b(this.i);
        return this.i;
    }

    zzw k() {
        return this.g;
    }

    public agf l() {
        b(this.q);
        return this.q;
    }

    public AppMeasurement m() {
        return this.j;
    }

    public ago n() {
        a(this.k);
        return this.k;
    }

    public ags o() {
        b(this.l);
        return this.l;
    }

    public ahe p() {
        b(this.m);
        return this.m;
    }

    public Context q() {
        return this.c;
    }

    public zn r() {
        return this.n;
    }

    public agg s() {
        b(this.o);
        return this.o;
    }

    public agu t() {
        b(this.p);
        return this.p;
    }

    public ahb u() {
        b(this.r);
        return this.r;
    }

    public ahf v() {
        if (this.s != null) {
            return this.s;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public agl w() {
        b(this.t);
        return this.t;
    }

    public agq x() {
        b(this.u);
        return this.u;
    }

    public void y() {
        h().j();
    }

    FileChannel z() {
        return this.z;
    }
}
