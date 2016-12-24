package defpackage;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;

/* compiled from: MeHistoryFragment */
class hw$2 implements OnRefreshListener {
    final /* synthetic */ hw a;

    hw$2(hw this$0) {
        this.a = this$0;
    }

    public void onRefresh() {
        this.a.f = this.a.a();
    }
}
