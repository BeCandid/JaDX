package defpackage;

import java.net.URL;

/* compiled from: UrlLoader */
public class mx<T> implements mr<URL, T> {
    private final mr<mj, T> a;

    public mx(mr<mj, T> glideUrlLoader) {
        this.a = glideUrlLoader;
    }

    public ku<T> a(URL model, int width, int height) {
        return this.a.a(new mj(model), width, height);
    }
}
