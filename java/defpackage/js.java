package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: BitmapTypeRequest */
public class js<ModelType> extends jr<ModelType, Bitmap> {
    private final mr<ModelType, InputStream> g;
    private final mr<ModelType, ParcelFileDescriptor> h;
    private final jx i;
    private final jz$d j;

    private static <A, R> qb<A, mm, Bitmap, R> a(jx glide, mr<A, InputStream> streamModelLoader, mr<A, ParcelFileDescriptor> fileDescriptorModelLoader, Class<R> transcodedClass, pf<Bitmap, R> transcoder) {
        if (streamModelLoader == null && fileDescriptorModelLoader == null) {
            return null;
        }
        if (transcoder == null) {
            transcoder = glide.a(Bitmap.class, (Class) transcodedClass);
        }
        return new qb(new ml(streamModelLoader, fileDescriptorModelLoader), transcoder, glide.b(mm.class, Bitmap.class));
    }

    js(jv<ModelType, ?, ?, ?> other, mr<ModelType, InputStream> streamModelLoader, mr<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader, jz$d optionsApplier) {
        super(js.a(other.c, streamModelLoader, fileDescriptorModelLoader, Bitmap.class, null), Bitmap.class, other);
        this.g = streamModelLoader;
        this.h = fileDescriptorModelLoader;
        this.i = other.c;
        this.j = optionsApplier;
    }
}
