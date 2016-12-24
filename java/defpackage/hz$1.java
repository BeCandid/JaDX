package defpackage;

import android.util.Log;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessagesActiveFragment */
class hz$1 extends apr<NetworkData> {
    final /* synthetic */ String a;
    final /* synthetic */ hz b;

    hz$1(hz this$0, String str) {
        this.b = this$0;
        this.a = str;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
        this.b.j.setRefreshing(false);
        this.b.a();
    }

    public void onError(Throwable e) {
        this.b.j.setRefreshing(false);
        this.b.a();
        rj.a(e);
        Log.d("MessagesActive", e.toString());
    }

    public void a(NetworkData networkData) {
        if (networkData.threads != null) {
            ArrayList<MessageThread> online = new ArrayList();
            for (MessageThread thread : networkData.threads) {
                if (thread.online == 1) {
                    online.add(thread);
                }
            }
            if (this.a.equals("0")) {
                this.b.a((List) online);
            } else {
                this.b.i.b((List) online);
            }
            if (networkData.thread_next_page != 0) {
                this.b.i.a(networkData.thread_next_page);
            } else {
                this.b.i.a(null);
            }
        }
    }
}
