package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* compiled from: FileDescriptorBitmapDataLoadProvider */
public class nv implements py<ParcelFileDescriptor, Bitmap> {
    private final kp<File, Bitmap> a;
    private final nw b;
    private final nq c = new nq();
    private final km<ParcelFileDescriptor> d = nl.b();

    public nv(ln bitmapPool, DecodeFormat decodeFormat) {
        this.a = new ok(new od(bitmapPool, decodeFormat));
        this.b = new nw(bitmapPool, decodeFormat);
    }

    public kp<File, Bitmap> a() {
        return this.a;
    }

    public kp<ParcelFileDescriptor, Bitmap> b() {
        return this.b;
    }

    public km<ParcelFileDescriptor> c() {
        return this.d;
    }

    public kq<Bitmap> d() {
        return this.c;
    }
}
