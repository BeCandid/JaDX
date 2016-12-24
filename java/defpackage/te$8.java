package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class te$8 implements FilenameFilter {
    te$8() {
    }

    public boolean accept(File file, String filename) {
        return te.e.matcher(filename).matches();
    }
}
