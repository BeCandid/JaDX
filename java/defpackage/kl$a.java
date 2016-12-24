package defpackage;

import android.content.Context;
import java.io.InputStream;
import okhttp3.Call.Factory;
import okhttp3.OkHttpClient;

/* compiled from: OkHttpUrlLoader */
public class kl$a implements ms<mj, InputStream> {
    private static volatile Factory a;
    private Factory b;

    public kl$a() {
        this(kl$a.b());
    }

    public kl$a(Factory client) {
        this.b = client;
    }

    private static Factory b() {
        if (a == null) {
            synchronized (kl$a.class) {
                if (a == null) {
                    a = new OkHttpClient();
                }
            }
        }
        return a;
    }

    public mr<mj, InputStream> a(Context context, mi factories) {
        return new kl(this.b);
    }

    public void a() {
    }
}
