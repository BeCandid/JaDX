package defpackage;

import android.content.Context;
import android.os.Handler;
import android.view.View;

/* compiled from: ImageLoadingUtil */
class is$3 implements ij$a {
    final /* synthetic */ Context a;
    final /* synthetic */ View b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ View e;

    is$3(Context context, View view, int i, int i2, View view2) {
        this.a = context;
        this.b = view;
        this.c = i;
        this.d = i2;
        this.e = view2;
    }

    public void a(long bytesRead, long contentLength, boolean done) {
        Handler handler = new Handler(this.a.getMainLooper());
        if (done) {
            handler.post(new is$3$2(this));
        } else {
            handler.post(new is$3$1(this, bytesRead, contentLength));
        }
    }
}
