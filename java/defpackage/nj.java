package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* compiled from: StreamUriLoader */
public class nj extends mw<InputStream> implements ng<Uri> {
    public nj(Context context, mr<mj, InputStream> urlLoader) {
        super(context, urlLoader);
    }

    protected ku<InputStream> a(Context context, Uri uri) {
        return new la(context, uri);
    }

    protected ku<InputStream> a(Context context, String assetPath) {
        return new kz(context.getApplicationContext().getAssets(), assetPath);
    }
}
