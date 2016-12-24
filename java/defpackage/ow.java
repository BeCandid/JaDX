package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifBitmapWrapper */
public class ow {
    private final lj<on> a;
    private final lj<Bitmap> b;

    public ow(lj<Bitmap> bitmapResource, lj<on> gifResource) {
        if (bitmapResource != null && gifResource != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        } else if (bitmapResource == null && gifResource == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        } else {
            this.b = bitmapResource;
            this.a = gifResource;
        }
    }

    public int a() {
        if (this.b != null) {
            return this.b.c();
        }
        return this.a.c();
    }

    public lj<Bitmap> b() {
        return this.b;
    }

    public lj<on> c() {
        return this.a;
    }
}
