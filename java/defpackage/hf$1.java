package defpackage;

import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MainTabsActivity;

/* compiled from: FeedAdapter */
class hf$1 extends apr<in$q> {
    final /* synthetic */ BaseActivity a;
    final /* synthetic */ hf b;

    hf$1(hf this$0, BaseActivity baseActivity) {
        this.b = this$0;
        this.a = baseActivity;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$q) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$q didLikePost) {
        if (!(didLikePost.h instanceof MainTabsActivity) || !(this.a instanceof MainTabsActivity)) {
            this.b.a(didLikePost.a, didLikePost);
        }
    }
}
