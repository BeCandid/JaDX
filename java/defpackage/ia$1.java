package defpackage;

import android.util.Log;
import com.becandid.candid.models.NetworkData;

/* compiled from: MessagesRequestsFragment */
class ia$1 extends apr<NetworkData> {
    final /* synthetic */ String a;
    final /* synthetic */ ia b;

    ia$1(ia this$0, String str) {
        this.b = this$0;
        this.a = str;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
        this.b.e.setRefreshing(false);
        this.b.a();
    }

    public void onError(Throwable e) {
        this.b.e.setRefreshing(false);
        this.b.a();
        rj.a(e);
        Log.d("MessagesRequests", e.toString());
    }

    public void a(NetworkData networkData) {
        if (networkData.requests != null) {
            if (this.a.equals("0")) {
                this.b.a(networkData.requests);
            } else {
                this.b.d.b(networkData.requests);
            }
            if (networkData.request_next_page != 0) {
                this.b.d.a(networkData.request_next_page);
            } else {
                this.b.d.a(null);
            }
        }
    }
}
