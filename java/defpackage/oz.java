package defpackage;

import android.graphics.Bitmap;
import java.io.OutputStream;

/* compiled from: GifBitmapWrapperResourceEncoder */
public class oz implements kq<ow> {
    private final kq<Bitmap> a;
    private final kq<on> b;
    private String c;

    public oz(kq<Bitmap> bitmapEncoder, kq<on> gifEncoder) {
        this.a = bitmapEncoder;
        this.b = gifEncoder;
    }

    public boolean a(lj<ow> resource, OutputStream os) {
        ow gifBitmap = (ow) resource.b();
        lj<Bitmap> bitmapResource = gifBitmap.b();
        if (bitmapResource != null) {
            return this.a.a(bitmapResource, os);
        }
        return this.b.a(gifBitmap.c(), os);
    }

    public String a() {
        if (this.c == null) {
            this.c = this.a.a() + this.b.a();
        }
        return this.c;
    }
}
