package defpackage;

import android.support.v7.widget.StaggeredGridLayoutManager;
import rx.schedulers.Schedulers;

/* compiled from: MeGroupsFragment */
class hv$3 extends hn {
    final /* synthetic */ hv a;

    hv$3(hv this$0, StaggeredGridLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            ik.a().i(Integer.parseInt(minPostId)).b(Schedulers.io()).a(apv.a()).b(new hv$3$1(this));
        }
    }
}
