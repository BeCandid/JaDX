package defpackage;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

/* compiled from: QueueFileLogStore */
class tq implements tk {
    private final File a;
    private final int b;
    private aly c;

    public tq(File workingFile, int maxLogSize) {
        this.a = workingFile;
        this.b = maxLogSize;
    }

    public void a(long timestamp, String msg) {
        d();
        b(timestamp, msg);
    }

    public sw a() {
        if (!this.a.exists()) {
            return null;
        }
        d();
        if (this.c == null) {
            return null;
        }
        int[] offsetHolder = new int[]{0};
        byte[] logBytes = new byte[this.c.a()];
        try {
            this.c.a(new tq$1(this, logBytes, offsetHolder));
        } catch (IOException e) {
            akx.h().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return sw.a(logBytes, 0, offsetHolder[0]);
    }

    public void b() {
        CommonUtils.a(this.c, "There was a problem closing the Crashlytics log file.");
        this.c = null;
    }

    public void c() {
        b();
        this.a.delete();
    }

    private void d() {
        if (this.c == null) {
            try {
                this.c = new aly(this.a);
            } catch (IOException e) {
                akx.h().e("CrashlyticsCore", "Could not open log file: " + this.a, e);
            }
        }
    }

    private void b(long timestamp, String msg) {
        if (this.c != null) {
            if (msg == null) {
                msg = "null";
            }
            try {
                int quarterMaxLogSize = this.b / 4;
                if (msg.length() > quarterMaxLogSize) {
                    msg = "..." + msg.substring(msg.length() - quarterMaxLogSize);
                }
                msg = msg.replaceAll("\r", " ").replaceAll("\n", " ");
                this.c.a(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(timestamp), msg}).getBytes("UTF-8"));
                while (!this.c.b() && this.c.a() > this.b) {
                    this.c.c();
                }
            } catch (IOException e) {
                akx.h().e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
