package defpackage;

import com.facebook.GraphRequest.b;
import org.json.JSONObject;

/* compiled from: AccessTokenManager */
class uh$3 implements b {
    final /* synthetic */ uh$a a;
    final /* synthetic */ uh b;

    uh$3(uh this$0, uh$a uh_a) {
        this.b = this$0;
        this.a = uh_a;
    }

    public void onCompleted(uo response) {
        JSONObject data = response.b();
        if (data != null) {
            this.a.a = data.optString("access_token");
            this.a.b = data.optInt("expires_at");
        }
    }
}
