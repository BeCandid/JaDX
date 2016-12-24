package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifBitmapWrapperTransformation */
public class pb implements kr<ow> {
    private final kr<Bitmap> a;
    private final kr<on> b;

    public pb(ln bitmapPool, kr<Bitmap> bitmapTransformation) {
        this((kr) bitmapTransformation, new oq(bitmapTransformation, bitmapPool));
    }

    pb(kr<Bitmap> bitmapTransformation, kr<on> gifDataTransformation) {
        this.a = bitmapTransformation;
        this.b = gifDataTransformation;
    }

    public lj<ow> a(lj<ow> resource, int outWidth, int outHeight) {
        lj<Bitmap> bitmapResource = ((ow) resource.b()).b();
        lj<on> gifResource = ((ow) resource.b()).c();
        if (bitmapResource != null && this.a != null) {
            lj<Bitmap> transformed = this.a.a(bitmapResource, outWidth, outHeight);
            if (bitmapResource.equals(transformed)) {
                return resource;
            }
            return new ox(new ow(transformed, ((ow) resource.b()).c()));
        } else if (gifResource == null || this.b == null) {
            return resource;
        } else {
            lj<on> transformed2 = this.b.a(gifResource, outWidth, outHeight);
            if (gifResource.equals(transformed2)) {
                return resource;
            }
            return new ox(new ow(((ow) resource.b()).b(), transformed2));
        }
    }

    public String a() {
        return this.a.a();
    }
}
