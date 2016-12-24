package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifFrameResourceDecoder */
class ot implements kp<kd, Bitmap> {
    private final ln a;

    public ot(ln bitmapPool) {
        this.a = bitmapPool;
    }

    public lj<Bitmap> a(kd source, int width, int height) {
        return nr.a(source.f(), this.a);
    }

    public String a() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }
}
