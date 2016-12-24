package defpackage;

import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ik$10 implements aqc<NetworkData, apl<NetworkData>> {
    final /* synthetic */ ik a;

    ik$10(ik this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apl<NetworkData> a(NetworkData networkData) {
        if (networkData == null || !networkData.success) {
            return null;
        }
        return apl.a((Object) networkData);
    }
}
