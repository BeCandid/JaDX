package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: FileDescriptorResourceLoader */
public class na$a implements ms<Integer, ParcelFileDescriptor> {
    public mr<Integer, ParcelFileDescriptor> a(Context context, mi factories) {
        return new na(context, factories.a(Uri.class, ParcelFileDescriptor.class));
    }

    public void a() {
    }
}
