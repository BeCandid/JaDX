package defpackage;

import com.becandid.candid.data.Post;
import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ik$22 implements aqc<NetworkData, apl<Post>> {
    final /* synthetic */ ik a;

    ik$22(ik this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apl<Post> a(NetworkData networkData) {
        if (networkData != null) {
            return apl.a(networkData.post);
        }
        return null;
    }
}
