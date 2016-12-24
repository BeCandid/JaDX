package defpackage;

import android.util.Log;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: Logger */
public class vx {
    private static final HashMap<String, String> a = new HashMap();
    private final LoggingBehavior b;
    private final String c;
    private StringBuilder d;
    private int e = 3;

    public static synchronized void a(String original, String replace) {
        synchronized (vx.class) {
            a.put(original, replace);
        }
    }

    public static synchronized void a(String accessToken) {
        synchronized (vx.class) {
            if (!ul.a(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                vx.a(accessToken, "ACCESS_TOKEN_REMOVED");
            }
        }
    }

    public static void a(LoggingBehavior behavior, String tag, String string) {
        vx.a(behavior, 3, tag, string);
    }

    public static void a(LoggingBehavior behavior, String tag, String format, Object... args) {
        if (ul.a(behavior)) {
            vx.a(behavior, 3, tag, String.format(format, args));
        }
    }

    public static void a(LoggingBehavior behavior, int priority, String tag, String format, Object... args) {
        if (ul.a(behavior)) {
            vx.a(behavior, priority, tag, String.format(format, args));
        }
    }

    public static void a(LoggingBehavior behavior, int priority, String tag, String string) {
        if (ul.a(behavior)) {
            string = vx.d(string);
            if (!tag.startsWith("FacebookSDK.")) {
                tag = "FacebookSDK." + tag;
            }
            Log.println(priority, tag, string);
            if (behavior == LoggingBehavior.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    private static synchronized String d(String string) {
        synchronized (vx.class) {
            for (Entry<String, String> entry : a.entrySet()) {
                string = string.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
        }
        return string;
    }

    public vx(LoggingBehavior behavior, String tag) {
        wf.a(tag, "tag");
        this.b = behavior;
        this.c = "FacebookSDK." + tag;
        this.d = new StringBuilder();
    }

    public void a() {
        b(this.d.toString());
        this.d = new StringBuilder();
    }

    public void b(String string) {
        vx.a(this.b, this.e, this.c, string);
    }

    public void c(String string) {
        if (b()) {
            this.d.append(string);
        }
    }

    public void a(String format, Object... args) {
        if (b()) {
            this.d.append(String.format(format, args));
        }
    }

    public void a(String key, Object value) {
        a("  %s:\t%s\n", key, value);
    }

    private boolean b() {
        return ul.a(this.b);
    }
}
