package defpackage;

import android.content.Context;

/* compiled from: ImageDownloader */
class vr$b implements Runnable {
    private Context a;
    private vr$d b;

    vr$b(Context context, vr$d key) {
        this.a = context;
        this.b = key;
    }

    public void run() {
        vr.b(this.b, this.a);
    }
}
