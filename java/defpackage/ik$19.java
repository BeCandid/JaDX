package defpackage;

import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ik$19 implements aqc<NetworkData, apl<Group>> {
    final /* synthetic */ ik a;

    ik$19(ik this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apl<Group> a(NetworkData data) {
        if (data != null) {
            return apl.a(data.group);
        }
        return null;
    }
}
