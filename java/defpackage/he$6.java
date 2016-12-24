package defpackage;

import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.data.Comment;
import rx.schedulers.Schedulers;

/* compiled from: CommentsAdapter */
class he$6 implements OnClickListener {
    final /* synthetic */ jd a;
    final /* synthetic */ Comment b;
    final /* synthetic */ he c;

    he$6(he this$0, jd jdVar, Comment comment) {
        this.c = this$0;
        this.a = jdVar;
        this.b = comment;
    }

    public void onClick(View v) {
        int value;
        in$aq update;
        if (this.a.o.isSelected()) {
            value = 0;
            update = new in$aq(this.b.comment_id, 0, this.b.num_likes, this.b.num_dislikes - 1);
        } else {
            value = -1;
            if (this.a.l.isSelected()) {
                update = new in$aq(this.b.comment_id, -1, this.b.num_likes - 1, this.b.num_dislikes + 1);
            } else {
                update = new in$aq(this.b.comment_id, -1, this.b.num_likes, this.b.num_dislikes + 1);
            }
        }
        ix.a().a(update);
        ik.a().a(this.b.comment_id, value).b(Schedulers.io()).a(apv.a()).b(new he$6$1(this));
    }
}
