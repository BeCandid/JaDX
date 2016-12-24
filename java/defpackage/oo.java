package defpackage;

import android.content.Context;
import java.io.File;
import java.io.InputStream;

/* compiled from: GifDrawableLoadProvider */
public class oo implements py<InputStream, on> {
    private final ou a;
    private final ov b;
    private final mu c;
    private final ok<on> d = new ok(this.a);

    public oo(Context context, ln bitmapPool) {
        this.a = new ou(context, bitmapPool);
        this.b = new ov(bitmapPool);
        this.c = new mu();
    }

    public kp<File, on> a() {
        return this.d;
    }

    public kp<InputStream, on> b() {
        return this.a;
    }

    public km<InputStream> c() {
        return this.c;
    }

    public kq<on> d() {
        return this.b;
    }
}
