package defpackage;

import com.becandid.candid.models.PostInfoResponse;
import java.util.Map;

/* compiled from: ApiService */
class ik$21 implements aqc<PostInfoResponse, apl<Map<String, String>>> {
    final /* synthetic */ ik a;

    ik$21(ik this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((PostInfoResponse) obj);
    }

    public apl<Map<String, String>> a(PostInfoResponse postInfoResponse) {
        if (postInfoResponse != null) {
            return apl.a(postInfoResponse.data);
        }
        return null;
    }
}
