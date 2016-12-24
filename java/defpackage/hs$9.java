package defpackage;

import com.becandid.candid.data.Post;
import java.util.List;

/* compiled from: FeedFragment */
class hs$9 extends apr<List<Post>> {
    final /* synthetic */ hs a;

    hs$9(hs this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((List) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
        jb.a(this.a.e, this.a.b);
    }

    public void a(List<Post> posts) {
        if (posts == null || posts.isEmpty()) {
            this.a.b.a(null);
        } else if (posts.size() != 1 || (posts.get(0) instanceof Post)) {
            this.a.b.b((List) posts);
            this.a.b.a(Integer.toString(((Post) posts.get(posts.size() - 1)).post_id));
        }
    }
}
