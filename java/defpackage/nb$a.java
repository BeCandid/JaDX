package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: FileDescriptorStringLoader */
public class nb$a implements ms<String, ParcelFileDescriptor> {
    public mr<String, ParcelFileDescriptor> a(Context context, mi factories) {
        return new nb(factories.a(Uri.class, ParcelFileDescriptor.class));
    }

    public void a() {
    }
}
