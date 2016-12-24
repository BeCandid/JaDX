package defpackage;

import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;

/* compiled from: LikeActionController */
class ws$l extends ws$a {
    final /* synthetic */ ws e;
    private String f;

    ws$l(ws wsVar, String unlikeToken) {
        this.e = wsVar;
        super(wsVar, null, null);
        this.f = unlikeToken;
        a(new GraphRequest(AccessToken.a(), unlikeToken, null, HttpMethod.DELETE));
    }

    protected void a(uo response) {
    }

    protected void a(FacebookRequestError error) {
        vx.a(LoggingBehavior.REQUESTS, ws.a, "Error unliking object with unlike token '%s' : %s", this.f, error);
        this.e.a("publish_unlike", error);
    }
}
