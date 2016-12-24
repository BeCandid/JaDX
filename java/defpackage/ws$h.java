package defpackage;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.share.widget.LikeView.ObjectType;
import org.json.JSONArray;

/* compiled from: LikeActionController */
class ws$h extends ws$a implements ws$i {
    final /* synthetic */ ws e;
    private boolean f = this.e.m;
    private String g;

    ws$h(ws wsVar, String pageId) {
        this.e = wsVar;
        super(wsVar, pageId, ObjectType.PAGE);
        this.g = pageId;
        Bundle requestParams = new Bundle();
        requestParams.putString("fields", "id");
        a(new GraphRequest(AccessToken.a(), "me/likes/" + pageId, requestParams, HttpMethod.GET));
    }

    protected void a(uo response) {
        JSONArray dataSet = we.c(response.b(), "data");
        if (dataSet != null && dataSet.length() > 0) {
            this.f = true;
        }
    }

    protected void a(FacebookRequestError error) {
        vx.a(LoggingBehavior.REQUESTS, ws.a, "Error fetching like status for page id '%s': %s", this.g, error);
        this.e.a("get_page_like", error);
    }

    public boolean b() {
        return this.f;
    }

    public String c() {
        return null;
    }
}
