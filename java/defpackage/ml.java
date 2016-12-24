package defpackage;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: ImageVideoModelLoader */
public class ml<A> implements mr<A, mm> {
    private final mr<A, InputStream> a;
    private final mr<A, ParcelFileDescriptor> b;

    public ml(mr<A, InputStream> streamLoader, mr<A, ParcelFileDescriptor> fileDescriptorLoader) {
        if (streamLoader == null && fileDescriptorLoader == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.a = streamLoader;
        this.b = fileDescriptorLoader;
    }

    public ku<mm> a(A model, int width, int height) {
        ku<InputStream> streamFetcher = null;
        if (this.a != null) {
            streamFetcher = this.a.a(model, width, height);
        }
        ku<ParcelFileDescriptor> fileDescriptorFetcher = null;
        if (this.b != null) {
            fileDescriptorFetcher = this.b.a(model, width, height);
        }
        if (streamFetcher == null && fileDescriptorFetcher == null) {
            return null;
        }
        return new ml$a(streamFetcher, fileDescriptorFetcher);
    }
}
