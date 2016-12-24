package defpackage;

import android.graphics.Bitmap;

/* compiled from: FitCenter */
public class nx extends ns {
    public nx(ln bitmapPool) {
        super(bitmapPool);
    }

    protected Bitmap a(ln pool, Bitmap toTransform, int outWidth, int outHeight) {
        return oe.a(toTransform, pool, outWidth, outHeight);
    }

    public String a() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }
}
