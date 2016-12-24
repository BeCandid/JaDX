package defpackage;

import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Post;

/* compiled from: FeedFragment */
class hs$6 extends apr<in$ah> {
    final /* synthetic */ hs a;

    hs$6(hs this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((in$ah) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(in$ah relatedPosts) {
        if (this.a.b != null && this.a.e != null && this.a.c != null) {
            if (!relatedPosts.b && this.a.c.equals("home")) {
                this.a.a(relatedPosts.a);
            } else if (relatedPosts.c != null && this.a.c.equals(relatedPosts.c) && AppState.relatedPosts != null && !AppState.relatedPosts.isEmpty()) {
                int row = this.a.b.d(relatedPosts.a);
                if (row >= 0) {
                    ((Post) AppState.relatedPosts.get(0)).first_related_post = 1;
                    this.a.b.a(row + 1, AppState.relatedPosts);
                }
            }
        }
    }
}
