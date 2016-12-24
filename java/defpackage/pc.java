package defpackage;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* compiled from: ImageVideoGifDrawableLoadProvider */
public class pc implements py<mm, ow> {
    private final kp<File, ow> a;
    private final kp<mm, ow> b;
    private final kq<ow> c;
    private final km<mm> d;

    public pc(py<mm, Bitmap> bitmapProvider, py<InputStream, on> gifProvider, ln bitmapPool) {
        oy decoder = new oy(bitmapProvider.b(), gifProvider.b(), bitmapPool);
        this.a = new ok(new pa(decoder));
        this.b = decoder;
        this.c = new oz(bitmapProvider.d(), gifProvider.d());
        this.d = bitmapProvider.c();
    }

    public kp<File, ow> a() {
        return this.a;
    }

    public kp<mm, ow> b() {
        return this.b;
    }

    public km<mm> c() {
        return this.d;
    }

    public kq<ow> d() {
        return this.c;
    }
}
