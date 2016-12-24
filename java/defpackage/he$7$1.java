package defpackage;

import com.becandid.candid.activities.PostDetailsActivity;

/* compiled from: CommentsAdapter */
class he$7$1 implements Runnable {
    final /* synthetic */ he$7 a;

    he$7$1(he$7 this$1) {
        this.a = this$1;
    }

    public void run() {
        ((PostDetailsActivity) this.a.d.f).scrollToComment(this.a.b.comment_id);
    }
}
