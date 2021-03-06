package defpackage;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.InputStream;

/* compiled from: ImageVideoModelLoader */
class ml$a implements ku<mm> {
    private final ku<InputStream> a;
    private final ku<ParcelFileDescriptor> b;

    public /* synthetic */ Object b(Priority x0) throws Exception {
        return a(x0);
    }

    public ml$a(ku<InputStream> streamFetcher, ku<ParcelFileDescriptor> fileDescriptorFetcher) {
        this.a = streamFetcher;
        this.b = fileDescriptorFetcher;
    }

    public mm a(Priority priority) throws Exception {
        InputStream is = null;
        if (this.a != null) {
            try {
                is = (InputStream) this.a.b(priority);
            } catch (Exception e) {
                if (Log.isLoggable("IVML", 2)) {
                    Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", e);
                }
                if (this.b == null) {
                    throw e;
                }
            }
        }
        ParcelFileDescriptor fileDescriptor = null;
        if (this.b != null) {
            try {
                fileDescriptor = (ParcelFileDescriptor) this.b.b(priority);
            } catch (Exception e2) {
                if (Log.isLoggable("IVML", 2)) {
                    Log.v("IVML", "Exception fetching ParcelFileDescriptor", e2);
                }
                if (is == null) {
                    throw e2;
                }
            }
        }
        return new mm(is, fileDescriptor);
    }

    public void a() {
        if (this.a != null) {
            this.a.a();
        }
        if (this.b != null) {
            this.b.a();
        }
    }

    public String b() {
        if (this.a != null) {
            return this.a.b();
        }
        return this.b.b();
    }

    public void c() {
        if (this.a != null) {
            this.a.c();
        }
        if (this.b != null) {
            this.b.c();
        }
    }
}
