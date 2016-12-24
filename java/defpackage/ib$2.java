package defpackage;

import android.support.v7.widget.LinearLayoutManager;

/* compiled from: MessagesThreadsFragment */
class ib$2 extends hn {
    final /* synthetic */ ib a;

    ib$2(ib this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            this.a.b(minPostId);
        }
    }
}
