package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifBitmapWrapperDrawableTranscoder */
public class pd implements pf<ow, oh> {
    private final pf<Bitmap, ny> a;

    public pd(pf<Bitmap, ny> bitmapDrawableResourceTranscoder) {
        this.a = bitmapDrawableResourceTranscoder;
    }

    public lj<oh> a(lj<ow> toTranscode) {
        ow gifBitmap = (ow) toTranscode.b();
        lj<Bitmap> bitmapResource = gifBitmap.b();
        if (bitmapResource != null) {
            return this.a.a(bitmapResource);
        }
        return gifBitmap.c();
    }

    public String a() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
