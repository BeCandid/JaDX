package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;

/* compiled from: BitmapPreFiller */
public final class mf {
    private final mb a;
    private final ln b;
    private final DecodeFormat c;
    private final Handler d = new Handler(Looper.getMainLooper());

    public mf(mb memoryCache, ln bitmapPool, DecodeFormat defaultFormat) {
        this.a = memoryCache;
        this.b = bitmapPool;
        this.c = defaultFormat;
    }
}
