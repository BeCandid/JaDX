package defpackage;

import android.content.Context;
import android.net.Uri;

/* compiled from: ImageRequest */
public class vs$a {
    private Context a;
    private Uri b;
    private vs$b c;
    private boolean d;
    private Object e;

    public vs$a(Context context, Uri imageUri) {
        wf.a((Object) imageUri, "imageUri");
        this.a = context;
        this.b = imageUri;
    }

    public vs$a a(vs$b callback) {
        this.c = callback;
        return this;
    }

    public vs$a a(Object callerTag) {
        this.e = callerTag;
        return this;
    }

    public vs$a a(boolean allowCachedRedirects) {
        this.d = allowCachedRedirects;
        return this;
    }

    public vs a() {
        return new vs();
    }
}
