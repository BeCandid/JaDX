package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ClsFileOutputStream */
class sy$1 implements FilenameFilter {
    sy$1() {
    }

    public boolean accept(File dir, String filename) {
        return filename.endsWith(".cls_temp");
    }
}
