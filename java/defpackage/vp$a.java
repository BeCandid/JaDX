package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: FileLruCache */
class vp$a {
    private static final FilenameFilter a = new vp$a$1();
    private static final FilenameFilter b = new vp$a$2();

    static void a(File root) {
        File[] filesToDelete = root.listFiles(vp$a.b());
        if (filesToDelete != null) {
            for (File file : filesToDelete) {
                file.delete();
            }
        }
    }

    static FilenameFilter a() {
        return a;
    }

    static FilenameFilter b() {
        return b;
    }

    static File b(File root) {
        return new File(root, "buffer" + Long.valueOf(vp.b.incrementAndGet()).toString());
    }
}
