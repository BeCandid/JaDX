package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class te$d implements FilenameFilter {
    private final String a;

    public te$d(String sessionId) {
        this.a = sessionId;
    }

    public boolean accept(File file, String fileName) {
        if (fileName.equals(this.a + ".cls") || !fileName.contains(this.a) || fileName.endsWith(".cls_temp")) {
            return false;
        }
        return true;
    }
}
