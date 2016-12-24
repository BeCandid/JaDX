package defpackage;

import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Post;
import java.util.List;

/* compiled from: FeedFragment */
class hs$7$1 extends apr<List<Post>> {
    final /* synthetic */ hs$7 a;

    hs$7$1(hs$7 this$1) {
        this.a = this$1;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((List) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rj.a(e);
    }

    public void a(List<Post> posts) {
        for (Post post : posts) {
            List<Integer> matches = this.a.a.b.a(post);
            if (!(matches.isEmpty() || AppState.expandedPostIds.contains(Integer.valueOf(post.post_id)))) {
                for (Integer i : matches) {
                    this.a.a.b.a(i.intValue(), post);
                }
            }
        }
    }
}
