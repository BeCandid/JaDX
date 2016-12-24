package defpackage;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;

/* compiled from: MePostsFragment */
class hx$2 implements OnRefreshListener {
    final /* synthetic */ hx a;

    hx$2(hx this$0) {
        this.a = this$0;
    }

    public void onRefresh() {
        this.a.f = this.a.a();
    }
}
