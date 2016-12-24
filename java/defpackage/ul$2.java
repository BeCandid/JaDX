package defpackage;

import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: FacebookSdk */
class ul$2 implements Callable<File> {
    ul$2() {
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public File a() throws Exception {
        return ul.m.getCacheDir();
    }
}
