package defpackage;

import com.facebook.GraphRequest;
import com.facebook.GraphRequest.b;
import com.facebook.appevents.AccessTokenAppIdPair;

/* compiled from: AppEventQueue */
class uy$4 implements b {
    final /* synthetic */ AccessTokenAppIdPair a;
    final /* synthetic */ GraphRequest b;
    final /* synthetic */ vb c;
    final /* synthetic */ va d;

    uy$4(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, vb vbVar, va vaVar) {
        this.a = accessTokenAppIdPair;
        this.b = graphRequest;
        this.c = vbVar;
        this.d = vaVar;
    }

    public void onCompleted(uo response) {
        uy.b(this.a, this.b, response, this.c, this.d);
    }
}
