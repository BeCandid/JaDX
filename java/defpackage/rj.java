package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* compiled from: Crashlytics */
public class rj extends alc<Void> implements ald {
    public final rk a;
    public final sn b;
    public final sz c;
    public final Collection<? extends alc> d;

    protected /* synthetic */ Object f() {
        return d();
    }

    public rj() {
        this(new rk(), new sn(), new sz());
    }

    rj(rk answers, sn beta, sz core) {
        this.a = answers;
        this.b = beta;
        this.c = core;
        this.d = Collections.unmodifiableCollection(Arrays.asList(new alc[]{answers, beta, core}));
    }

    public String a() {
        return "2.6.1.139";
    }

    public String b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public Collection<? extends alc> c() {
        return this.d;
    }

    protected Void d() {
        return null;
    }

    public static rj e() {
        return (rj) akx.a(rj.class);
    }

    public static void a(Throwable throwable) {
        rj.g();
        rj.e().c.a(throwable);
    }

    public static void a(String msg) {
        rj.g();
        rj.e().c.a(msg);
    }

    private static void g() {
        if (rj.e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
