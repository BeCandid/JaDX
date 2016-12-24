package defpackage;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.share.widget.LikeView.ObjectType;
import org.json.JSONObject;

/* compiled from: LikeActionController */
class ws$g extends ws$a {
    String e;
    boolean f;
    final /* synthetic */ ws g;

    ws$g(ws wsVar, String objectId, ObjectType objectType) {
        this.g = wsVar;
        super(wsVar, objectId, objectType);
        Bundle pageIdRequestParams = new Bundle();
        pageIdRequestParams.putString("fields", "id");
        pageIdRequestParams.putString("ids", objectId);
        a(new GraphRequest(AccessToken.a(), "", pageIdRequestParams, HttpMethod.GET));
    }

    protected void a(uo response) {
        JSONObject results = we.b(response.b(), this.a);
        if (results != null) {
            this.e = results.optString("id");
            this.f = !we.a(this.e);
        }
    }

    protected void a(FacebookRequestError error) {
        vx.a(LoggingBehavior.REQUESTS, ws.a, "Error getting the FB id for object '%s' with type '%s' : %s", this.a, this.b, error);
    }
}
