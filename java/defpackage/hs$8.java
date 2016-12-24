package defpackage;

import com.becandid.candid.data.Post;
import java.util.List;

/* compiled from: FeedFragment */
class hs$8 extends apr<List<Post>> {
    final /* synthetic */ hs a;

    hs$8(hs this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((List) obj);
    }

    public void onCompleted() {
        this.a.e.scrollToPosition(0);
        this.a.e.setVisibility(0);
        this.a.g.setVisibility(8);
        this.a.f.setRefreshing(false);
    }

    public void onError(Throwable e) {
        this.a.g.setVisibility(8);
        this.a.f.setRefreshing(false);
    }

    public void a(List<Post> posts) {
        if (posts != null && !posts.isEmpty()) {
            if (posts.size() != 1 || (posts.get(0) instanceof Post)) {
                Post lastRelatedPost = null;
                for (Post post : posts) {
                    if (post.related_to_post > 0) {
                        if (lastRelatedPost == null) {
                            post.first_related_post = 1;
                        }
                        lastRelatedPost = post;
                    } else if (lastRelatedPost != null) {
                        lastRelatedPost.last_related_post = 1;
                        break;
                    }
                }
                this.a.b.a((List) posts);
                this.a.b.a(Integer.toString(((Post) posts.get(posts.size() - 1)).post_id));
            }
        }
    }
}
