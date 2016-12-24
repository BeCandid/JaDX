package defpackage;

import java.io.InputStream;
import okhttp3.Call.Factory;

/* compiled from: OkHttpUrlLoader */
public class kl implements mr<mj, InputStream> {
    private final Factory a;

    public kl(Factory client) {
        this.a = client;
    }

    public ku<InputStream> a(mj model, int width, int height) {
        return new kk(this.a, model);
    }
}
