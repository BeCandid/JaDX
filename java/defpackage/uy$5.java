package defpackage;

import com.facebook.appevents.AccessTokenAppIdPair;

/* compiled from: AppEventQueue */
class uy$5 implements Runnable {
    final /* synthetic */ AccessTokenAppIdPair a;
    final /* synthetic */ vb b;

    uy$5(AccessTokenAppIdPair accessTokenAppIdPair, vb vbVar) {
        this.a = accessTokenAppIdPair;
        this.b = vbVar;
    }

    public void run() {
        uz.a(this.a, this.b);
    }
}
