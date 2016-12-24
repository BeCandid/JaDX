package defpackage;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifBitmapWrapperResourceDecoder */
public class oy implements kp<mm, ow> {
    private static final oy$b a = new oy$b();
    private static final oy$a b = new oy$a();
    private final kp<mm, Bitmap> c;
    private final kp<InputStream, on> d;
    private final ln e;
    private final oy$b f;
    private final oy$a g;
    private String h;

    public oy(kp<mm, Bitmap> bitmapDecoder, kp<InputStream, on> gifDecoder, ln bitmapPool) {
        this(bitmapDecoder, gifDecoder, bitmapPool, a, b);
    }

    oy(kp<mm, Bitmap> bitmapDecoder, kp<InputStream, on> gifDecoder, ln bitmapPool, oy$b parser, oy$a streamFactory) {
        this.c = bitmapDecoder;
        this.d = gifDecoder;
        this.e = bitmapPool;
        this.f = parser;
        this.g = streamFactory;
    }

    public lj<ow> a(mm source, int width, int height) throws IOException {
        rb pool = rb.a();
        byte[] tempBytes = pool.b();
        ow owVar = null;
        try {
            owVar = a(source, width, height, tempBytes);
            return owVar != null ? new ox(owVar) : null;
        } finally {
            pool.a(tempBytes);
        }
    }

    private ow a(mm source, int width, int height, byte[] bytes) throws IOException {
        if (source.a() != null) {
            return b(source, width, height, bytes);
        }
        return b(source, width, height);
    }

    private ow b(mm source, int width, int height, byte[] bytes) throws IOException {
        InputStream bis = this.g.a(source.a(), bytes);
        bis.mark(2048);
        ImageType type = this.f.a(bis);
        bis.reset();
        ow result = null;
        if (type == ImageType.a) {
            result = a(bis, width, height);
        }
        if (result == null) {
            return b(new mm(bis, source.b()), width, height);
        }
        return result;
    }

    private ow a(InputStream bis, int width, int height) throws IOException {
        lj<on> gifResource = this.d.a(bis, width, height);
        if (gifResource == null) {
            return null;
        }
        on drawable = (on) gifResource.b();
        if (drawable.e() > 1) {
            return new ow(null, gifResource);
        }
        return new ow(new nr(drawable.b(), this.e), null);
    }

    private ow b(mm toDecode, int width, int height) throws IOException {
        lj<Bitmap> bitmapResource = this.c.a(toDecode, width, height);
        if (bitmapResource != null) {
            return new ow(bitmapResource, null);
        }
        return null;
    }

    public String a() {
        if (this.h == null) {
            this.h = this.d.a() + this.c.a();
        }
        return this.h;
    }
}
