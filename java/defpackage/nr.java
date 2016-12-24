package defpackage;

import android.graphics.Bitmap;

/* compiled from: BitmapResource */
public class nr implements lj<Bitmap> {
    private final Bitmap a;
    private final ln b;

    public /* synthetic */ Object b() {
        return a();
    }

    public static nr a(Bitmap bitmap, ln bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new nr(bitmap, bitmapPool);
    }

    public nr(Bitmap bitmap, ln bitmapPool) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (bitmapPool == null) {
            throw new NullPointerException("BitmapPool must not be null");
        } else {
            this.a = bitmap;
            this.b = bitmapPool;
        }
    }

    public Bitmap a() {
        return this.a;
    }

    public int c() {
        return ri.a(this.a);
    }

    public void d() {
        if (!this.b.a(this.a)) {
            this.a.recycle();
        }
    }
}
