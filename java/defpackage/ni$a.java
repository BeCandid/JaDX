package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* compiled from: StreamStringLoader */
public class ni$a implements ms<String, InputStream> {
    public mr<String, InputStream> a(Context context, mi factories) {
        return new ni(factories.a(Uri.class, InputStream.class));
    }

    public void a() {
    }
}
