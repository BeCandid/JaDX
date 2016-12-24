package defpackage;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder */
public class od implements kp<InputStream, Bitmap> {
    private final nu a;
    private ln b;
    private DecodeFormat c;
    private String d;

    public od(ln bitmapPool, DecodeFormat decodeFormat) {
        this(nu.a, bitmapPool, decodeFormat);
    }

    public od(nu downsampler, ln bitmapPool, DecodeFormat decodeFormat) {
        this.a = downsampler;
        this.b = bitmapPool;
        this.c = decodeFormat;
    }

    public lj<Bitmap> a(InputStream source, int width, int height) {
        return nr.a(this.a.a(source, this.b, width, height, this.c), this.b);
    }

    public String a() {
        if (this.d == null) {
            this.d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.a.a() + this.c.name();
        }
        return this.d;
    }
}
