package defpackage;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;

/* compiled from: MeActivityFragment */
class hu$2 implements OnRefreshListener {
    final /* synthetic */ hu a;

    hu$2(hu this$0) {
        this.a = this$0;
    }

    public void onRefresh() {
        if (this.a.f != null) {
            this.a.f.unsubscribe();
        }
        this.a.f = this.a.b(true);
    }
}
