package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* compiled from: StringLoader */
public class mv<T> implements mr<String, T> {
    private final mr<Uri, T> a;

    public mv(mr<Uri, T> uriLoader) {
        this.a = uriLoader;
    }

    public ku<T> a(String model, int width, int height) {
        if (TextUtils.isEmpty(model)) {
            return null;
        }
        Uri uri;
        if (model.startsWith("/")) {
            uri = mv.a(model);
        } else {
            uri = Uri.parse(model);
            if (uri.getScheme() == null) {
                uri = mv.a(model);
            }
        }
        return this.a.a(uri, width, height);
    }

    private static Uri a(String path) {
        return Uri.fromFile(new File(path));
    }
}
