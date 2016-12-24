package defpackage;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahv {
    static final Map<String, ahv> a = new dh();
    private static final List<String> b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final Set<String> e = Collections.emptySet();
    private static final Object f = new Object();
    private final Context g;
    private final String h;
    private final ahw i;
    private final AtomicBoolean j = new AtomicBoolean(true);
    private final AtomicBoolean k = new AtomicBoolean();
    private final List<Object> l = new CopyOnWriteArrayList();
    private final List<ahv$a> m = new CopyOnWriteArrayList();
    private final List<Object> n = new CopyOnWriteArrayList();

    protected ahv(Context context, String str, ahw ahw) {
        this.g = (Context) xz.a((Object) context);
        this.h = xz.a(str);
        this.i = (ahw) xz.a((Object) ahw);
    }

    public static ahv a(Context context) {
        ahw a = ahw.a(context);
        return a == null ? null : ahv.a(context, a);
    }

    public static ahv a(Context context, ahw ahw) {
        return ahv.a(context, ahw, "[DEFAULT]");
    }

    public static ahv a(Context context, ahw ahw, String str) {
        Object ahv;
        aar a = aar.a(context);
        ahv.b(context);
        String b = ahv.b(str);
        Object applicationContext = context.getApplicationContext();
        synchronized (f) {
            xz.a(!a.containsKey(b), new StringBuilder(String.valueOf(b).length() + 33).append("FirebaseApp name ").append(b).append(" already exists!").toString());
            xz.a(applicationContext, (Object) "Application context cannot be null.");
            ahv = new ahv(applicationContext, b, ahw);
            a.put(b, ahv);
        }
        a.a((ahv) ahv);
        ahv.a(ahv.class, ahv, b);
        if (ahv.e()) {
            ahv.a(ahv.class, ahv, c);
            ahv.a(Context.class, ahv.a(), d);
        }
        return ahv;
    }

    public static ahv a(String str) {
        ahv ahv;
        synchronized (f) {
            ahv = (ahv) a.get(ahv.b(str));
            if (ahv != null) {
            } else {
                String str2;
                Iterable g = ahv.g();
                if (g.isEmpty()) {
                    str2 = "";
                } else {
                    String str3 = "Available app names: ";
                    str2 = String.valueOf(za.a(", ").a(g));
                    str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return ahv;
    }

    private static <T> void a(Class<T> cls, T t, Iterable<String> iterable) {
        String valueOf;
        for (String valueOf2 : iterable) {
            try {
                Class cls2 = Class.forName(valueOf2);
                Method method = cls2.getMethod("getInstance", new Class[]{cls});
                if ((method.getModifiers() & 9) == 9) {
                    method.invoke(null, new Object[]{t});
                }
                String valueOf3 = String.valueOf(cls2);
                Log.d("FirebaseApp", new StringBuilder(String.valueOf(valueOf3).length() + 13).append("Initialized ").append(valueOf3).append(".").toString());
            } catch (ClassNotFoundException e) {
                if (e.contains(valueOf2)) {
                    throw new IllegalStateException(String.valueOf(valueOf2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                }
                Log.d("FirebaseApp", String.valueOf(valueOf2).concat(" is not linked. Skipping initialization."));
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException(String.valueOf(valueOf2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
            } catch (Throwable e3) {
                Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
            } catch (Throwable e4) {
                String str = "FirebaseApp";
                String str2 = "Failed to initialize ";
                valueOf2 = String.valueOf(valueOf2);
                Log.wtf(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e4);
            }
        }
    }

    public static void a(boolean z) {
        synchronized (f) {
            Iterator it = new ArrayList(a.values()).iterator();
            while (it.hasNext()) {
                ahv ahv = (ahv) it.next();
                if (ahv.j.get()) {
                    ahv.b(z);
                }
            }
        }
    }

    private static String b(String str) {
        return str.trim();
    }

    @TargetApi(14)
    private static void b(Context context) {
        if (zt.c() && (context.getApplicationContext() instanceof Application)) {
            aaq.a((Application) context.getApplicationContext());
        }
    }

    private void b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (ahv$a a : this.m) {
            a.a(z);
        }
    }

    public static ahv d() {
        return ahv.a("[DEFAULT]");
    }

    private void f() {
        xz.a(!this.k.get(), (Object) "FirebaseApp was deleted");
    }

    private static List<String> g() {
        Collection zlVar = new zl();
        synchronized (f) {
            for (ahv b : a.values()) {
                zlVar.add(b.b());
            }
            aar a = aar.a();
            if (a != null) {
                zlVar.addAll(a.b());
            }
        }
        List<String> arrayList = new ArrayList(zlVar);
        Collections.sort(arrayList);
        return arrayList;
    }

    public Context a() {
        f();
        return this.g;
    }

    public String b() {
        f();
        return this.h;
    }

    public ahw c() {
        f();
        return this.i;
    }

    public boolean e() {
        return "[DEFAULT]".equals(b());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof ahv) ? false : this.h.equals(((ahv) obj).b());
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    public String toString() {
        return zc.a((Object) this).a("name", this.h).a("options", this.i).toString();
    }
}
