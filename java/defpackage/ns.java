package defpackage;

import android.content.Context;
import android.graphics.Bitmap;

/* compiled from: BitmapTransformation */
public abstract class ns implements kr<Bitmap> {
    private ln a;

    protected abstract Bitmap a(ln lnVar, Bitmap bitmap, int i, int i2);

    public ns(Context context) {
        this(jx.a(context).a());
    }

    public ns(ln bitmapPool) {
        this.a = bitmapPool;
    }

    public final lj<Bitmap> a(lj<Bitmap> resource, int outWidth, int outHeight) {
        if (ri.a(outWidth, outHeight)) {
            int targetWidth;
            int targetHeight;
            Bitmap toTransform = (Bitmap) resource.b();
            if (outWidth == Integer.MIN_VALUE) {
                targetWidth = toTransform.getWidth();
            } else {
                targetWidth = outWidth;
            }
            if (outHeight == Integer.MIN_VALUE) {
                targetHeight = toTransform.getHeight();
            } else {
                targetHeight = outHeight;
            }
            Bitmap transformed = a(this.a, toTransform, targetWidth, targetHeight);
            if (toTransform.equals(transformed)) {
                return resource;
            }
            return nr.a(transformed, this.a);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + outWidth + " or height: " + outHeight + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
