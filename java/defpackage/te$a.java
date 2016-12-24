package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class te$a implements FilenameFilter {
    private te$a() {
    }

    public boolean accept(File file, String fileName) {
        return !te.a.accept(file, fileName) && te.e.matcher(fileName).matches();
    }
}
