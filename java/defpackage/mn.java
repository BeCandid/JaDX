package defpackage;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ImageVideoWrapperEncoder */
public class mn implements km<mm> {
    private final km<InputStream> a;
    private final km<ParcelFileDescriptor> b;
    private String c;

    public mn(km<InputStream> streamEncoder, km<ParcelFileDescriptor> fileDescriptorEncoder) {
        this.a = streamEncoder;
        this.b = fileDescriptorEncoder;
    }

    public boolean a(mm data, OutputStream os) {
        if (data.a() != null) {
            return this.a.a(data.a(), os);
        }
        return this.b.a(data.b(), os);
    }

    public String a() {
        if (this.c == null) {
            this.c = this.a.a() + this.b.a();
        }
        return this.c;
    }
}
