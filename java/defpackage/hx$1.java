package defpackage;

import android.view.View;
import com.becandid.candid.models.NetworkData;

/* compiled from: MePostsFragment */
class hx$1 extends apr<NetworkData> {
    final /* synthetic */ hx a;

    hx$1(hx this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
        this.a.e.setRefreshing(false);
        this.a.d.setVisibility(this.a.c.getItemCount() == 0 ? 0 : 8);
        this.a.b.scrollToPosition(0);
    }

    public void onError(Throwable e) {
        int i = 0;
        rj.a(e);
        this.a.e.setRefreshing(false);
        View c = this.a.d;
        if (this.a.c.getItemCount() != 0) {
            i = 8;
        }
        c.setVisibility(i);
    }

    public void a(NetworkData networkData) {
        if (networkData.success) {
            if (networkData.posts != null) {
                this.a.c.a(networkData.posts);
            }
            if (networkData.next_page != 0) {
                this.a.c.a(String.valueOf(networkData.next_page));
            } else {
                this.a.c.a(null);
            }
        }
    }
}
