package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class te$b implements FilenameFilter {
    private final String a;

    public te$b(String s) {
        this.a = s;
    }

    public boolean accept(File dir, String filename) {
        return filename.contains(this.a) && !filename.endsWith(".cls_temp");
    }
}
