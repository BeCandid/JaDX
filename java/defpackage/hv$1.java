package defpackage;

import com.becandid.candid.models.NetworkData;

/* compiled from: MeGroupsFragment */
class hv$1 extends apr<NetworkData> {
    final /* synthetic */ hv a;

    hv$1(hv this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
    }

    public void a(NetworkData networkData) {
        if (networkData.success) {
            if (networkData.groups != null) {
                this.a.c.a(networkData.groups);
            }
            if (networkData.next_page != 0) {
                this.a.c.a(String.valueOf(networkData.next_page));
            } else {
                this.a.c.a(null);
            }
        }
    }
}
