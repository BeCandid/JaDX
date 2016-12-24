package defpackage;

import java.io.InputStream;

/* compiled from: HttpUrlGlideUrlLoader */
public class nd implements mr<mj, InputStream> {
    private final mq<mj, mj> a;

    public nd() {
        this(null);
    }

    public nd(mq<mj, mj> modelCache) {
        this.a = modelCache;
    }

    public ku<InputStream> a(mj model, int width, int height) {
        mj url = model;
        if (this.a != null) {
            url = (mj) this.a.a(model, 0, 0);
            if (url == null) {
                this.a.a(model, 0, 0, model);
                url = model;
            }
        }
        return new kx(url);
    }
}
