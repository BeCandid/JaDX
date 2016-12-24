package defpackage;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.share.widget.LikeView.ObjectType;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: LikeActionController */
class ws$d extends ws$a {
    String e = this.i.n;
    String f = this.i.o;
    String g = this.i.p;
    String h = this.i.q;
    final /* synthetic */ ws i;

    ws$d(ws wsVar, String objectId, ObjectType objectType) {
        this.i = wsVar;
        super(wsVar, objectId, objectType);
        Bundle requestParams = new Bundle();
        requestParams.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
        requestParams.putString("locale", Locale.getDefault().toString());
        a(new GraphRequest(AccessToken.a(), objectId, requestParams, HttpMethod.GET));
    }

    protected void a(uo response) {
        JSONObject engagementResults = we.b(response.b(), "engagement");
        if (engagementResults != null) {
            this.e = engagementResults.optString("count_string_with_like", this.e);
            this.f = engagementResults.optString("count_string_without_like", this.f);
            this.g = engagementResults.optString("social_sentence_with_like", this.g);
            this.h = engagementResults.optString("social_sentence_without_like", this.h);
        }
    }

    protected void a(FacebookRequestError error) {
        vx.a(LoggingBehavior.REQUESTS, ws.a, "Error fetching engagement for object '%s' with type '%s' : %s", this.a, this.b, error);
        this.i.a("get_engagement", error);
    }
}
