package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* compiled from: FileDescriptorFileLoader */
public class my$a implements ms<File, ParcelFileDescriptor> {
    public mr<File, ParcelFileDescriptor> a(Context context, mi factories) {
        return new my(factories.a(Uri.class, ParcelFileDescriptor.class));
    }

    public void a() {
    }
}
