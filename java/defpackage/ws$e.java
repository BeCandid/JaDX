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
class ws$e extends ws$a {
    String e;
    final /* synthetic */ ws f;

    ws$e(ws wsVar, String objectId, ObjectType objectType) {
        this.f = wsVar;
        super(wsVar, objectId, objectType);
        Bundle objectIdRequestParams = new Bundle();
        objectIdRequestParams.putString("fields", "og_object.fields(id)");
        objectIdRequestParams.putString("ids", objectId);
        a(new GraphRequest(AccessToken.a(), "", objectIdRequestParams, HttpMethod.GET));
    }

    protected void a(FacebookRequestError error) {
        if (error.e().contains("og_object")) {
            this.c = null;
            return;
        }
        vx.a(LoggingBehavior.REQUESTS, ws.a, "Error getting the FB id for object '%s' with type '%s' : %s", this.a, this.b, error);
    }

    protected void a(uo response) {
        JSONObject results = we.b(response.b(), this.a);
        if (results != null) {
            JSONObject ogObject = results.optJSONObject("og_object");
            if (ogObject != null) {
                this.e = ogObject.optString("id");
            }
        }
    }
}
