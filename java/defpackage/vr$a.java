package defpackage;

import android.content.Context;

/* compiled from: ImageDownloader */
class vr$a implements Runnable {
    private Context a;
    private vr$d b;
    private boolean c;

    vr$a(Context context, vr$d key, boolean allowCachedRedirects) {
        this.a = context;
        this.b = key;
        this.c = allowCachedRedirects;
    }

    public void run() {
        vr.b(this.b, this.a, this.c);
    }
}
