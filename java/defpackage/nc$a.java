package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: FileDescriptorUriLoader */
public class nc$a implements ms<Uri, ParcelFileDescriptor> {
    public mr<Uri, ParcelFileDescriptor> a(Context context, mi factories) {
        return new nc(context, factories.a(mj.class, ParcelFileDescriptor.class));
    }

    public void a() {
    }
}
