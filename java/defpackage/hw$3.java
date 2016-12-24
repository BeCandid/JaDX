package defpackage;

import com.becandid.candid.models.NetworkData;

/* compiled from: MeHistoryFragment */
class hw$3 extends apr<NetworkData> {
    final /* synthetic */ hw a;

    hw$3(hw this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
        jb.a(this.a.b, this.a.c);
    }

    public void a(NetworkData data) {
        if (data == null || data.posts == null || data.posts.isEmpty()) {
            this.a.c.a(null);
            return;
        }
        this.a.c.b(data.posts);
        if (data.next_page != 0) {
            this.a.c.a(String.valueOf(data.next_page));
        } else {
            this.a.c.a(null);
        }
    }
}
