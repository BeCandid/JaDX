package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper */
public class ly implements lu {
    private static ly a = null;
    private final lw b = new lw();
    private final md c;
    private final File d;
    private final int e;
    private ka f;

    public static synchronized lu a(File directory, int maxSize) {
        lu luVar;
        synchronized (ly.class) {
            if (a == null) {
                a = new ly(directory, maxSize);
            }
            luVar = a;
        }
        return luVar;
    }

    protected ly(File directory, int maxSize) {
        this.d = directory;
        this.e = maxSize;
        this.c = new md();
    }

    private synchronized ka a() throws IOException {
        if (this.f == null) {
            this.f = ka.a(this.d, 1, 1, (long) this.e);
        }
        return this.f;
    }

    public File a(kn key) {
        File result = null;
        try {
            ka$c value = a().a(this.c.a(key));
            if (value != null) {
                result = value.a(0);
            }
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            }
        }
        return result;
    }

    public void a(kn key, lu$b writer) {
        ka$a editor;
        String safeKey = this.c.a(key);
        this.b.a(key);
        try {
            editor = a().b(safeKey);
            if (editor != null) {
                if (writer.a(editor.a(0))) {
                    editor.a();
                }
                editor.c();
            }
            this.b.b(key);
        } catch (IOException e) {
            try {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
                this.b.b(key);
            } catch (Throwable th) {
                this.b.b(key);
            }
        } catch (Throwable th2) {
            editor.c();
        }
    }

    public void b(kn key) {
        try {
            a().c(this.c.a(key));
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }
}
