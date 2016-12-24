package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.InputStream;

/* compiled from: StreamFileLoader */
public class nf$a implements ms<File, InputStream> {
    public mr<File, InputStream> a(Context context, mi factories) {
        return new nf(factories.a(Uri.class, InputStream.class));
    }

    public void a() {
    }
}
