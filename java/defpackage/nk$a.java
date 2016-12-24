package defpackage;

import android.content.Context;
import java.io.InputStream;
import java.net.URL;

/* compiled from: StreamUrlLoader */
public class nk$a implements ms<URL, InputStream> {
    public mr<URL, InputStream> a(Context context, mi factories) {
        return new nk(factories.a(mj.class, InputStream.class));
    }

    public void a() {
    }
}
