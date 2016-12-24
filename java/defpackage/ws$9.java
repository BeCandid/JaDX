package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.LoggingBehavior;

/* compiled from: LikeActionController */
class ws$9 extends wx {
    final /* synthetic */ Bundle a;
    final /* synthetic */ ws b;

    ws$9(ws this$0, uk callback, Bundle bundle) {
        this.b = this$0;
        this.a = bundle;
        super(callback);
    }

    public void a(vf appCall, Bundle data) {
        if (data != null && data.containsKey("object_is_liked")) {
            String unlikeToken;
            boolean isObjectLiked = data.getBoolean("object_is_liked");
            String likeCountStringWithLike = this.b.n;
            String likeCountStringWithoutLike = this.b.o;
            if (data.containsKey("like_count_string")) {
                likeCountStringWithLike = data.getString("like_count_string");
                likeCountStringWithoutLike = likeCountStringWithLike;
            }
            String socialSentenceWithLike = this.b.p;
            String socialSentenceWithoutWithoutLike = this.b.q;
            if (data.containsKey("social_sentence")) {
                socialSentenceWithLike = data.getString("social_sentence");
                socialSentenceWithoutWithoutLike = socialSentenceWithLike;
            }
            if (data.containsKey("object_is_liked")) {
                unlikeToken = data.getString("unlike_token");
            } else {
                unlikeToken = this.b.r;
            }
            Bundle logParams = this.a == null ? new Bundle() : this.a;
            logParams.putString("call_id", appCall.c().toString());
            this.b.l().a("fb_like_control_dialog_did_succeed", null, logParams);
            this.b.a(isObjectLiked, likeCountStringWithLike, likeCountStringWithoutLike, socialSentenceWithLike, socialSentenceWithoutWithoutLike, unlikeToken);
        }
    }

    public void a(vf appCall, FacebookException error) {
        vx.a(LoggingBehavior.REQUESTS, ws.a, "Like Dialog failed with error : %s", error);
        Bundle logParams = this.a == null ? new Bundle() : this.a;
        logParams.putString("call_id", appCall.c().toString());
        this.b.a("present_dialog", logParams);
        ws.c(this.b, "com.facebook.sdk.LikeActionController.DID_ERROR", vz.a(error));
    }

    public void a(vf appCall) {
        a(appCall, new FacebookOperationCanceledException());
    }
}
