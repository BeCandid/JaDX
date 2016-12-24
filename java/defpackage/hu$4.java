package defpackage;

import android.support.v7.widget.LinearLayoutManager;
import rx.schedulers.Schedulers;

/* compiled from: MeActivityFragment */
class hu$4 extends hn {
    final /* synthetic */ hu a;

    hu$4(hu this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            ik.a().b(Boolean.toString(true), minPostId).b(Schedulers.io()).a(apv.a()).b(new hu$4$1(this));
        }
    }
}
