package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.crashlytics.android.core.CrashlyticsMissingDependencyException;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@amd(a = {tz.class})
/* compiled from: CrashlyticsCore */
public class sz extends alc<Void> {
    private anb A;
    private ta B;
    private tz C;
    private final long a;
    private final ConcurrentHashMap<String, String> b;
    private File c;
    private ang d;
    private tb k;
    private tb l;
    private tc m;
    private te n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private float x;
    private boolean y;
    private final tp z;

    protected /* synthetic */ Object f() {
        return c();
    }

    public sz() {
        this(1.0f, null, null, false);
    }

    sz(float delay, tc listener, tp pinningInfo, boolean disabled) {
        this(delay, listener, pinningInfo, disabled, alw.a("Crashlytics Exception Handler"));
    }

    sz(float delay, tc listener, tp pinningInfo, boolean disabled, ExecutorService crashHandlerExecutor) {
        this.o = null;
        this.p = null;
        this.q = null;
        this.x = delay;
        if (listener == null) {
            listener = new sz$b();
        }
        this.m = listener;
        this.z = pinningInfo;
        this.y = disabled;
        this.B = new ta(crashHandlerExecutor);
        this.b = new ConcurrentHashMap();
        this.a = System.currentTimeMillis();
    }

    protected boolean a_() {
        return a(super.E());
    }

    boolean a(Context context) {
        if (this.y) {
            return false;
        }
        this.t = new alr().a(context);
        if (this.t == null) {
            return false;
        }
        akx.h().c("CrashlyticsCore", "Initializing Crashlytics " + a());
        this.d = new anh(this);
        this.l = new tb("crash_marker", this.d);
        this.k = new tb("initialization_marker", this.d);
        try {
            a(context, this.t);
            tv unityVersionProvider = new tm(context, h());
            boolean initializeSynchronously = u();
            K();
            a(unityVersionProvider);
            if (!initializeSynchronously || !CommonUtils.n(context)) {
                return true;
            }
            J();
            return false;
        } catch (CrashlyticsMissingDependencyException e) {
            throw new UnmetDependencyException(e);
        } catch (Exception e2) {
            akx.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e2);
            return false;
        }
    }

    private void a(Context context, String apiKey) throws NameNotFoundException {
        td infoProvider = this.z != null ? new td(this.z) : null;
        this.A = new ana(akx.h());
        this.A.a(infoProvider);
        this.s = context.getPackageName();
        this.u = D().j();
        akx.h().a("CrashlyticsCore", "Installer package name is: " + this.u);
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.s, 0);
        this.v = Integer.toString(packageInfo.versionCode);
        this.w = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
        this.r = CommonUtils.m(context);
        a(this.r, sz.b(context)).a(apiKey, this.s);
    }

    private void a(tv unityVersionProvider) {
        try {
            akx.h().a("CrashlyticsCore", "Installing exception handler...");
            this.n = new te(Thread.getDefaultUncaughtExceptionHandler(), this.B, D(), unityVersionProvider, this.d, this);
            this.n.b();
            Thread.setDefaultUncaughtExceptionHandler(this.n);
            akx.h().a("CrashlyticsCore", "Successfully installed exception handler.");
        } catch (Exception e) {
            akx.h().e("CrashlyticsCore", "There was a problem installing the exception handler.", e);
        }
    }

    protected Void c() {
        s();
        this.n.g();
        try {
            aoc settingsData = aoa.a().b();
            if (settingsData == null) {
                akx.h().d("CrashlyticsCore", "Received null settings, skipping initialization!");
            } else if (settingsData.d.c) {
                this.n.c();
                tg call = a(settingsData);
                if (call == null) {
                    akx.h().d("CrashlyticsCore", "Unable to create a call to upload reports.");
                    t();
                } else {
                    new ts(call).a(this.x);
                    t();
                }
            } else {
                akx.h().a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                t();
            }
        } catch (Exception e) {
            akx.h().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            t();
        }
        return null;
    }

    public String b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String a() {
        return "2.3.10.127";
    }

    public static sz e() {
        return (sz) akx.a(sz.class);
    }

    public void a(Throwable throwable) {
        if (this.y || !sz.b("prior to logging exceptions.")) {
            return;
        }
        if (throwable == null) {
            akx.h().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.n.a(Thread.currentThread(), throwable);
        }
    }

    public void a(String msg) {
        a(3, "CrashlyticsCore", msg);
    }

    private void a(int priority, String tag, String msg) {
        if (!this.y && sz.b("prior to logging messages.")) {
            this.n.a(System.currentTimeMillis() - this.a, sz.b(priority, tag, msg));
        }
    }

    static void a(String sessionId, String exceptionName) {
        rk answers = (rk) akx.a(rk.class);
        if (answers != null) {
            answers.a(new alt$b(sessionId, exceptionName));
        }
    }

    static void b(String sessionId, String exceptionName) {
        rk answers = (rk) akx.a(rk.class);
        if (answers != null) {
            answers.a(new alt$a(sessionId, exceptionName));
        }
    }

    Map<String, String> g() {
        return Collections.unmodifiableMap(this.b);
    }

    sv a(String buildId, boolean requireBuildId) {
        return new sv(buildId, requireBuildId);
    }

    String h() {
        return this.s;
    }

    String i() {
        return this.t;
    }

    String j() {
        return this.u;
    }

    String k() {
        return this.w;
    }

    String l() {
        return this.v;
    }

    String m() {
        return CommonUtils.b(E(), "com.crashlytics.ApiEndpoint");
    }

    String n() {
        return this.r;
    }

    te o() {
        return this.n;
    }

    String p() {
        return D().a() ? this.o : null;
    }

    String q() {
        return D().a() ? this.p : null;
    }

    String r() {
        return D().a() ? this.q : null;
    }

    private void J() {
        amf<Void> callable = new sz$1(this);
        for (amk task : I()) {
            callable.a(task);
        }
        Future<Void> future = F().f().submit(callable);
        akx.h().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            future.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            akx.h().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            akx.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            akx.h().e("CrashlyticsCore", "Crashlytics timed out during initialization.", e3);
        }
    }

    void s() {
        this.B.a(new sz$2(this));
    }

    void t() {
        this.B.b(new sz$3(this));
    }

    boolean u() {
        return ((Boolean) this.B.a(new sz$4(this))).booleanValue();
    }

    ud v() {
        if (this.C != null) {
            return this.C.a();
        }
        return null;
    }

    File w() {
        if (this.c == null) {
            this.c = new anh(this).a();
        }
        return this.c;
    }

    boolean x() {
        return ((Boolean) aoa.a().a(new sz$5(this), Boolean.valueOf(false))).booleanValue();
    }

    boolean y() {
        return new anj(this).a().getBoolean("always_send_reports_opt_in", false);
    }

    @SuppressLint({"CommitPrefEdits"})
    void a(boolean send) {
        ani prefStore = new anj(this);
        prefStore.a(prefStore.b().putBoolean("always_send_reports_opt_in", send));
    }

    boolean z() {
        return ((Boolean) aoa.a().a(new sz$6(this), Boolean.valueOf(true))).booleanValue();
    }

    tg a(aoc settingsData) {
        if (settingsData != null) {
            return new th(this, m(), settingsData.a.d, this.A);
        }
        return null;
    }

    private void K() {
        if (Boolean.TRUE.equals((Boolean) this.B.a(new sz$a(this.l)))) {
            try {
                this.m.a();
            } catch (Exception e) {
                akx.h().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void A() {
        this.l.a();
    }

    private boolean a(Activity context, any promptData) {
        tj stringResolver = new tj(context, promptData);
        sz$c latch = new sz$c();
        Activity activity = context;
        activity.runOnUiThread(new sz$7(this, activity, latch, stringResolver, promptData));
        akx.h().a("CrashlyticsCore", "Waiting for user opt-in.");
        latch.b();
        return latch.a();
    }

    static anz B() {
        aoc settingsData = aoa.a().b();
        return settingsData == null ? null : settingsData.b;
    }

    private static boolean b(Context context) {
        return CommonUtils.a(context, "com.crashlytics.RequireBuildId", true);
    }

    private static String b(int priority, String tag, String msg) {
        return CommonUtils.b(priority) + "/" + tag + " " + msg;
    }

    private static boolean b(String msg) {
        sz instance = sz.e();
        if (instance != null && instance.n != null) {
            return true;
        }
        akx.h().e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + msg, null);
        return false;
    }

    private static int b(float density, int dips) {
        return (int) (((float) dips) * density);
    }
}
