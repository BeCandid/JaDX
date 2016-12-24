package defpackage;

import android.graphics.Bitmap;

/* compiled from: ImageDownloader */
class vr$1 implements Runnable {
    final /* synthetic */ vs a;
    final /* synthetic */ Exception b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Bitmap d;
    final /* synthetic */ vs$b e;

    vr$1(vs vsVar, Exception exception, boolean z, Bitmap bitmap, vs$b vs_b) {
        this.a = vsVar;
        this.b = exception;
        this.c = z;
        this.d = bitmap;
        this.e = vs_b;
    }

    public void run() {
        this.e.a(new vt(this.a, this.b, this.c, this.d));
    }
}
