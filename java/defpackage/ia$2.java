package defpackage;

import android.support.v7.widget.LinearLayoutManager;

/* compiled from: MessagesRequestsFragment */
class ia$2 extends hn {
    final /* synthetic */ ia a;

    ia$2(ia this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            this.a.b(minPostId);
        }
    }
}
