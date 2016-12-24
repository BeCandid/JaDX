package defpackage;

import android.content.Context;

/* compiled from: InternalCacheDiskCacheFactory */
public final class lz extends lx {
    public lz(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public lz(Context context, String diskCacheName, int diskCacheSize) {
        super(new lz$1(context, diskCacheName), diskCacheSize);
    }
}
