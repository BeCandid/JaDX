package defpackage;

import java.io.File;

/* compiled from: DiskLruCacheFactory */
public class lx implements lu$a {
    private final int a;
    private final lx$a b;

    public lx(lx$a cacheDirectoryGetter, int diskCacheSize) {
        this.a = diskCacheSize;
        this.b = cacheDirectoryGetter;
    }

    public lu a() {
        File cacheDir = this.b.a();
        if (cacheDir == null) {
            return null;
        }
        if (cacheDir.mkdirs() || (cacheDir.exists() && cacheDir.isDirectory())) {
            return ly.a(cacheDir, this.a);
        }
        return null;
    }
}
