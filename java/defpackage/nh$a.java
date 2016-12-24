package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* compiled from: StreamResourceLoader */
public class nh$a implements ms<Integer, InputStream> {
    public mr<Integer, InputStream> a(Context context, mi factories) {
        return new nh(context, factories.a(Uri.class, InputStream.class));
    }

    public void a() {
    }
}
