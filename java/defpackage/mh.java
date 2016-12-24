package defpackage;

import android.net.Uri;
import java.io.File;

/* compiled from: FileLoader */
public class mh<T> implements mr<File, T> {
    private final mr<Uri, T> a;

    public mh(mr<Uri, T> uriLoader) {
        this.a = uriLoader;
    }

    public ku<T> a(File model, int width, int height) {
        return this.a.a(Uri.fromFile(model), width, height);
    }
}
