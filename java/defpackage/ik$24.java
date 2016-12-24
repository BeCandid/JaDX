package defpackage;

import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;

/* compiled from: ApiService */
class ik$24 implements aqc<NetworkData, apl<NetworkData>> {
    final /* synthetic */ ik a;

    ik$24(ik this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apl<NetworkData> a(NetworkData networkData) {
        if (networkData == null || !networkData.success) {
            return null;
        }
        if (AppState.groups == null) {
            AppState.groups = new ArrayList();
        }
        AppState.groups.add(networkData.group);
        ix.a().a(new in$m(networkData.group));
        return apl.a((Object) networkData);
    }
}
