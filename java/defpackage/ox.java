package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifBitmapWrapperResource */
public class ox implements lj<ow> {
    private final ow a;

    public /* synthetic */ Object b() {
        return a();
    }

    public ox(ow data) {
        if (data == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.a = data;
    }

    public ow a() {
        return this.a;
    }

    public int c() {
        return this.a.a();
    }

    public void d() {
        lj<Bitmap> bitmapResource = this.a.b();
        if (bitmapResource != null) {
            bitmapResource.d();
        }
        lj<on> gifDataResource = this.a.c();
        if (gifDataResource != null) {
            gifDataResource.d();
        }
    }
}
