package defpackage;

import java.io.File;
import java.util.Comparator;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class te$6 implements Comparator<File> {
    te$6() {
    }

    public /* synthetic */ int compare(Object x0, Object x1) {
        return a((File) x0, (File) x1);
    }

    public int a(File file1, File file2) {
        return file2.getName().compareTo(file1.getName());
    }
}
