package defpackage;

import android.content.Context;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory */
class lz$1 implements lx$a {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    lz$1(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public File a() {
        File cacheDirectory = this.a.getCacheDir();
        if (cacheDirectory == null) {
            return null;
        }
        if (this.b != null) {
            return new File(cacheDirectory, this.b);
        }
        return cacheDirectory;
    }
}
