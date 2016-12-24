package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;

/* compiled from: FileDescriptorBitmapDecoder */
public class nw implements kp<ParcelFileDescriptor, Bitmap> {
    private final of a;
    private final ln b;
    private DecodeFormat c;

    public nw(ln bitmapPool, DecodeFormat decodeFormat) {
        this(new of(), bitmapPool, decodeFormat);
    }

    public nw(of bitmapDecoder, ln bitmapPool, DecodeFormat decodeFormat) {
        this.a = bitmapDecoder;
        this.b = bitmapPool;
        this.c = decodeFormat;
    }

    public lj<Bitmap> a(ParcelFileDescriptor source, int width, int height) throws IOException {
        return nr.a(this.a.a(source, this.b, width, height, this.c), this.b);
    }

    public String a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
