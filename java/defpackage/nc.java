package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: FileDescriptorUriLoader */
public class nc extends mw<ParcelFileDescriptor> implements mz<Uri> {
    public nc(Context context, mr<mj, ParcelFileDescriptor> urlLoader) {
        super(context, urlLoader);
    }

    protected ku<ParcelFileDescriptor> a(Context context, Uri uri) {
        return new kw(context, uri);
    }

    protected ku<ParcelFileDescriptor> a(Context context, String assetPath) {
        return new kv(context.getApplicationContext().getAssets(), assetPath);
    }
}
