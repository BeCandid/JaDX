package defpackage;

import android.graphics.Bitmap;

/* compiled from: ImageResponse */
public class vt {
    private vs a;
    private Exception b;
    private boolean c;
    private Bitmap d;

    vt(vs request, Exception error, boolean isCachedRedirect, Bitmap bitmap) {
        this.a = request;
        this.b = error;
        this.d = bitmap;
        this.c = isCachedRedirect;
    }

    public vs a() {
        return this.a;
    }

    public Exception b() {
        return this.b;
    }

    public Bitmap c() {
        return this.d;
    }

    public boolean d() {
        return this.c;
    }
}
