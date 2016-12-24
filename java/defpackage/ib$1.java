package defpackage;

import android.util.Log;
import com.becandid.candid.models.NetworkData;

/* compiled from: MessagesThreadsFragment */
class ib$1 extends apr<NetworkData> {
    final /* synthetic */ String a;
    final /* synthetic */ ib b;

    ib$1(ib this$0, String str) {
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
        Log.d("MessagesThreads", e.toString());
    }

    public void a(NetworkData networkData) {
        if (networkData.threads != null) {
            if (this.a.equals("0")) {
                this.b.a(networkData.threads);
            } else {
                this.b.d.b(networkData.threads);
            }
            if (networkData.thread_next_page != 0) {
                this.b.d.a(networkData.thread_next_page);
            } else {
                this.b.d.a(null);
            }
        }
    }
}
