package defpackage;

import java.util.concurrent.ExecutorService;

/* compiled from: Engine */
class lc$a {
    private final ExecutorService a;
    private final ExecutorService b;
    private final le c;

    public lc$a(ExecutorService diskCacheService, ExecutorService sourceService, le listener) {
        this.a = diskCacheService;
        this.b = sourceService;
        this.c = listener;
    }

    public ld a(kn key, boolean isMemoryCacheable) {
        return new ld(key, this.a, this.b, isMemoryCacheable, this.c);
    }
}
