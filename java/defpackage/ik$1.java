package defpackage;

import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ik$1 implements aqc<NetworkData, apl<NetworkData>> {
    final /* synthetic */ ik a;

    ik$1(ik this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apl<NetworkData> a(NetworkData networkData) {
        if (networkData != null) {
            return apl.a((Object) networkData);
        }
        return null;
    }
}
