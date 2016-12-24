package defpackage;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.share.widget.LikeView.ObjectType;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: LikeActionController */
class ws$f extends ws$a implements ws$i {
    final /* synthetic */ ws e;
    private boolean f = this.e.m;
    private String g;
    private final String h;
    private final ObjectType i;

    ws$f(ws wsVar, String objectId, ObjectType objectType) {
        this.e = wsVar;
        super(wsVar, objectId, objectType);
        this.h = objectId;
        this.i = objectType;
        Bundle requestParams = new Bundle();
        requestParams.putString("fields", "id,application");
        requestParams.putString("object", this.h);
        a(new GraphRequest(AccessToken.a(), "me/og.likes", requestParams, HttpMethod.GET));
    }

    protected void a(uo response) {
        JSONArray dataSet = we.c(response.b(), "data");
        if (dataSet != null) {
            for (int i = 0; i < dataSet.length(); i++) {
                JSONObject data = dataSet.optJSONObject(i);
                if (data != null) {
                    this.f = true;
                    JSONObject appData = data.optJSONObject("application");
                    AccessToken accessToken = AccessToken.a();
                    if (!(appData == null || accessToken == null || !we.a(accessToken.h(), appData.optString("id")))) {
                        this.g = data.optString("id");
                    }
                }
            }
        }
    }

    protected void a(FacebookRequestError error) {
        vx.a(LoggingBehavior.REQUESTS, ws.a, "Error fetching like status for object '%s' with type '%s' : %s", this.h, this.i, error);
        this.e.a("get_og_object_like", error);
    }

    public boolean b() {
        return this.f;
    }

    public String c() {
        return this.g;
    }
}
