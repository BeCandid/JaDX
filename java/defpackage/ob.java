package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

/* compiled from: ImageVideoDataLoadProvider */
public class ob implements py<mm, Bitmap> {
    private final oa a;
    private final kp<File, Bitmap> b;
    private final kq<Bitmap> c;
    private final mn d;

    public ob(py<InputStream, Bitmap> streamBitmapProvider, py<ParcelFileDescriptor, Bitmap> fileDescriptorBitmapProvider) {
        this.c = streamBitmapProvider.d();
        this.d = new mn(streamBitmapProvider.c(), fileDescriptorBitmapProvider.c());
        this.b = streamBitmapProvider.a();
        this.a = new oa(streamBitmapProvider.b(), fileDescriptorBitmapProvider.b());
    }

    public kp<File, Bitmap> a() {
        return this.b;
    }

    public kp<mm, Bitmap> b() {
        return this.a;
    }

    public km<mm> c() {
        return this.d;
    }

    public kq<Bitmap> d() {
        return this.c;
    }
}
