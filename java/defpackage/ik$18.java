package defpackage;

import com.becandid.candid.data.Post;
import com.becandid.candid.models.NetworkData;
import java.util.List;

/* compiled from: ApiService */
class ik$18 implements aqc<NetworkData, apl<List<Post>>> {
    final /* synthetic */ ik a;

    ik$18(ik this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apl<List<Post>> a(NetworkData networkData) {
        if (networkData != null) {
            return apl.a(networkData.posts);
        }
        return null;
    }
}
