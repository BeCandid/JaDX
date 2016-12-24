package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Fabric */
public class akx {
    static volatile akx a;
    static final alf b = new akw();
    final alf c;
    final boolean d;
    private final Context e;
    private final Map<Class<? extends alc>, alc> f;
    private final ExecutorService g;
    private final Handler h;
    private final ala<akx> i;
    private final ala<?> j;
    private final IdManager k;
    private akv l;
    private WeakReference<Activity> m;
    private AtomicBoolean n = new AtomicBoolean(false);

    static akx a() {
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    akx(Context context, Map<Class<? extends alc>, alc> kits, amj threadPoolExecutor, Handler mainHandler, alf logger, boolean debuggable, ala callback, IdManager idManager) {
        this.e = context;
        this.f = kits;
        this.g = threadPoolExecutor;
        this.h = mainHandler;
        this.c = logger;
        this.d = debuggable;
        this.i = callback;
        this.j = a(kits.size());
        this.k = idManager;
    }

    public static akx a(Context context, alc... kits) {
        if (a == null) {
            synchronized (akx.class) {
                if (a == null) {
                    akx.c(new akx$a(context).a(kits).a());
                }
            }
        }
        return a;
    }

    private static void c(akx fabric) {
        a = fabric;
        fabric.j();
    }

    public akx a(Activity activity) {
        this.m = new WeakReference(activity);
        return this;
    }

    public Activity b() {
        if (this.m != null) {
            return (Activity) this.m.get();
        }
        return null;
    }

    private void j() {
        a(c(this.e));
        this.l = new akv(this.e);
        this.l.a(new akx$1(this));
        a(this.e);
    }

    public String c() {
        return "1.3.12.127";
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
    }

    void a(Context context) {
        StringBuilder initInfo;
        Future<Map<String, ale>> installedKitsFuture = b(context);
        Collection<alc> providedKits = g();
        alg onboarding = new alg(installedKitsFuture, providedKits);
        List<alc> kits = new ArrayList(providedKits);
        Collections.sort(kits);
        onboarding.a(context, this, ala.d, this.k);
        for (alc kit : kits) {
            kit.a(context, this, this.j, this.k);
        }
        onboarding.C();
        if (akx.h().a("Fabric", 3)) {
            initInfo = new StringBuilder("Initializing ").append(d()).append(" [Version: ").append(c()).append("], with the following kits:\n");
        } else {
            initInfo = null;
        }
        for (alc kit2 : kits) {
            kit2.f.a(onboarding.f);
            a(this.f, kit2);
            kit2.C();
            if (initInfo != null) {
                initInfo.append(kit2.b()).append(" [Version: ").append(kit2.a()).append("]\n");
            }
        }
        if (initInfo != null) {
            akx.h().a("Fabric", initInfo.toString());
        }
    }

    void a(Map<Class<? extends alc>, alc> kits, alc dependentKit) {
        amd dependsOn = dependentKit.j;
        if (dependsOn != null) {
            for (Class<?> dependency : dependsOn.a()) {
                if (dependency.isInterface()) {
                    for (alc kit : kits.values()) {
                        if (dependency.isAssignableFrom(kit.getClass())) {
                            dependentKit.f.a(kit.f);
                        }
                    }
                } else if (((alc) kits.get(dependency)) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                } else {
                    dependentKit.f.a(((alc) kits.get(dependency)).f);
                }
            }
        }
    }

    private Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public akv e() {
        return this.l;
    }

    public ExecutorService f() {
        return this.g;
    }

    public Collection<alc> g() {
        return this.f.values();
    }

    public static <T extends alc> T a(Class<T> cls) {
        return (alc) akx.a().f.get(cls);
    }

    public static alf h() {
        if (a == null) {
            return b;
        }
        return a.c;
    }

    public static boolean i() {
        if (a == null) {
            return false;
        }
        return a.d;
    }

    private static Map<Class<? extends alc>, alc> b(Collection<? extends alc> kits) {
        Map map = new HashMap(kits.size());
        akx.a(map, (Collection) kits);
        return map;
    }

    private static void a(Map<Class<? extends alc>, alc> map, Collection<? extends alc> kits) {
        for (alc kit : kits) {
            map.put(kit.getClass(), kit);
            if (kit instanceof ald) {
                akx.a((Map) map, ((ald) kit).c());
            }
        }
    }

    ala<?> a(int size) {
        return new akx$2(this, size);
    }

    Future<Map<String, ale>> b(Context context) {
        return f().submit(new akz(context.getPackageCodePath()));
    }
}
