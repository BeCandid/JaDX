package defpackage;

import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ik$2 implements aqc<NetworkData, apl<EmptyClass>> {
    final /* synthetic */ ik a;

    ik$2(ik this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apl<EmptyClass> a(NetworkData networkData) {
        if (networkData == null || !networkData.success) {
            return null;
        }
        return apl.a(new EmptyClass());
    }
}
