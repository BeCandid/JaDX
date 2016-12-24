package defpackage;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: DrawableTypeRequest */
public class ju<ModelType> extends jt<ModelType> {
    private final mr<ModelType, InputStream> g;
    private final mr<ModelType, ParcelFileDescriptor> h;
    private final jz$d i;

    private static <A, Z, R> qb<A, mm, Z, R> a(jx glide, mr<A, InputStream> streamModelLoader, mr<A, ParcelFileDescriptor> fileDescriptorModelLoader, Class<Z> resourceClass, Class<R> transcodedClass, pf<Z, R> transcoder) {
        if (streamModelLoader == null && fileDescriptorModelLoader == null) {
            return null;
        }
        if (transcoder == null) {
            transcoder = glide.a((Class) resourceClass, (Class) transcodedClass);
        }
        return new qb(new ml(streamModelLoader, fileDescriptorModelLoader), transcoder, glide.b(mm.class, (Class) resourceClass));
    }

    ju(Class<ModelType> modelClass, mr<ModelType, InputStream> streamModelLoader, mr<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader, Context context, jx glide, pt requestTracker, po lifecycle, jz$d optionsApplier) {
        super(context, modelClass, ju.a(glide, streamModelLoader, fileDescriptorModelLoader, ow.class, oh.class, null), glide, requestTracker, lifecycle);
        this.g = streamModelLoader;
        this.h = fileDescriptorModelLoader;
        this.i = optionsApplier;
    }

    public js<ModelType> j() {
        return (js) this.i.a(new js(this, this.g, this.h, this.i));
    }
}
