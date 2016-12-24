package defpackage;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
import java.io.InputStream;

/* compiled from: StreamBitmapDataLoadProvider */
public class oc implements py<InputStream, Bitmap> {
    private final od a;
    private final nq b;
    private final mu c = new mu();
    private final ok<Bitmap> d;

    public oc(ln bitmapPool, DecodeFormat decodeFormat) {
        this.a = new od(bitmapPool, decodeFormat);
        this.b = new nq();
        this.d = new ok(this.a);
    }

    public kp<File, Bitmap> a() {
        return this.d;
    }

    public kp<InputStream, Bitmap> b() {
        return this.a;
    }

    public km<InputStream> c() {
        return this.c;
    }

    public kq<Bitmap> d() {
        return this.b;
    }
}
