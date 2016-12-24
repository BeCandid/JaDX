package defpackage;

import android.support.v7.widget.LinearLayoutManager;

/* compiled from: MessagesActiveFragment */
class hz$2 extends hn {
    final /* synthetic */ hz a;

    hz$2(hz this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null && Integer.valueOf(minPostId).intValue() > 0) {
            this.a.b(minPostId);
        }
    }
}
