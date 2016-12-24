package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ReportUploader */
class ts$1 implements FilenameFilter {
    ts$1() {
    }

    public boolean accept(File dir, String filename) {
        return filename.endsWith(".cls") && !filename.contains("Session");
    }
}
