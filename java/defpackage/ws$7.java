package defpackage;

import com.facebook.FacebookException;

/* compiled from: LikeActionController */
class ws$7 implements Runnable {
    final /* synthetic */ ws$c a;
    final /* synthetic */ ws b;
    final /* synthetic */ FacebookException c;

    ws$7(ws$c ws_c, ws wsVar, FacebookException facebookException) {
        this.a = ws_c;
        this.b = wsVar;
        this.c = facebookException;
    }

    public void run() {
        this.a.a(this.b, this.c);
    }
}
