package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.util.Base64;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.BoltsMeasurementEventListener;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FacebookSdk */
public final class ul {
    private static final String a = ul.class.getCanonicalName();
    private static final HashSet<LoggingBehavior> b = new HashSet(Arrays.asList(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS}));
    private static volatile Executor c;
    private static volatile String d;
    private static volatile String e;
    private static volatile String f;
    private static volatile int g;
    private static volatile String h = "facebook.com";
    private static AtomicLong i = new AtomicLong(65536);
    private static volatile boolean j = false;
    private static boolean k = false;
    private static vw<File> l;
    private static Context m;
    private static int n = 64206;
    private static final Object o = new Object();
    private static final BlockingQueue<Runnable> p = new LinkedBlockingQueue(10);
    private static final ThreadFactory q = new ul$1();
    private static Boolean r = Boolean.valueOf(false);

    public static synchronized void a(Context applicationContext) {
        synchronized (ul.class) {
            ul.a(applicationContext, null);
        }
    }

    public static synchronized void a(Context applicationContext, ul$a callback) {
        synchronized (ul.class) {
            if (!r.booleanValue()) {
                wf.a((Object) applicationContext, "applicationContext");
                wf.b(applicationContext, false);
                wf.a(applicationContext, false);
                m = applicationContext.getApplicationContext();
                ul.c(m);
                r = Boolean.valueOf(true);
                we.a(m, d);
                vz.b();
                BoltsMeasurementEventListener.a(m);
                l = new vw(new ul$2());
                ul.d().execute(new FutureTask(new ul$3(callback, applicationContext)));
            } else if (callback != null) {
                callback.a();
            }
        }
    }

    public static synchronized boolean a() {
        boolean booleanValue;
        synchronized (ul.class) {
            booleanValue = r.booleanValue();
        }
        return booleanValue;
    }

    public static boolean a(LoggingBehavior behavior) {
        boolean z;
        synchronized (b) {
            z = ul.b() && b.contains(behavior);
        }
        return z;
    }

    public static boolean b() {
        return j;
    }

    public static boolean c() {
        return k;
    }

    public static Executor d() {
        synchronized (o) {
            if (c == null) {
                c = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return c;
    }

    public static String e() {
        return h;
    }

    public static Context f() {
        wf.a();
        return m;
    }

    public static String g() {
        return "4.12.1";
    }

    public static boolean b(Context context) {
        wf.a();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static long h() {
        wf.a();
        return i.get();
    }

    static void c(Context context) {
        if (context != null) {
            try {
                ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (ai != null && ai.metaData != null) {
                    if (d == null) {
                        String appId = ai.metaData.get("com.facebook.sdk.ApplicationId");
                        if (appId instanceof String) {
                            String appIdString = appId;
                            if (appIdString.toLowerCase(Locale.ROOT).startsWith("fb")) {
                                d = appIdString.substring(2);
                            } else {
                                d = appIdString;
                            }
                        } else if (appId instanceof Integer) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (e == null) {
                        e = ai.metaData.getString("com.facebook.sdk.ApplicationName");
                    }
                    if (f == null) {
                        f = ai.metaData.getString("com.facebook.sdk.ClientToken");
                    }
                    if (g == 0) {
                        ul.a(ai.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                    }
                }
            } catch (NameNotFoundException e) {
            }
        }
    }

    public static String d(Context context) {
        wf.a();
        if (context == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            PackageInfo pInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatures = pInfo.signatures;
            if (signatures == null || signatures.length == 0) {
                return null;
            }
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                md.update(pInfo.signatures[0].toByteArray());
                return Base64.encodeToString(md.digest(), 9);
            } catch (NoSuchAlgorithmException e) {
                return null;
            }
        } catch (NameNotFoundException e2) {
            return null;
        }
    }

    public static String i() {
        wf.a();
        return d;
    }

    public static String j() {
        wf.a();
        return e;
    }

    public static String k() {
        wf.a();
        return f;
    }

    public static int l() {
        wf.a();
        return g;
    }

    public static void a(int theme) {
        if (theme == 0) {
            theme = 16973840;
        }
        g = theme;
    }

    public static File m() {
        wf.a();
        return (File) l.a();
    }

    public static int n() {
        wf.a();
        return n;
    }

    public static boolean b(int requestCode) {
        return requestCode >= n && requestCode < n + 100;
    }
}
