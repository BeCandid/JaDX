package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class te$5 implements FilenameFilter {
    final /* synthetic */ String a;
    final /* synthetic */ te b;

    te$5(te teVar, String str) {
        this.b = teVar;
        this.a = str;
    }

    public boolean accept(File f, String name) {
        return name.startsWith(this.a);
    }
}
