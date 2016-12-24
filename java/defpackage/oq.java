package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifDrawableTransformation */
public class oq implements kr<on> {
    private final kr<Bitmap> a;
    private final ln b;

    public oq(kr<Bitmap> wrapped, ln bitmapPool) {
        this.a = wrapped;
        this.b = bitmapPool;
    }

    public lj<on> a(lj<on> ljVar, int outWidth, int outHeight) {
        on drawable = (on) ljVar.b();
        Bitmap firstFrame = ((on) ljVar.b()).b();
        Bitmap transformedFrame = (Bitmap) this.a.a(new nr(firstFrame, this.b), outWidth, outHeight).b();
        if (transformedFrame.equals(firstFrame)) {
            return ljVar;
        }
        return new op(new on(drawable, transformedFrame, this.a));
    }

    public String a() {
        return this.a.a();
    }
}
