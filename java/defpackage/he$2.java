package defpackage;

import android.os.Handler;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.becandid.candid.data.Comment;

/* compiled from: CommentsAdapter */
class he$2 implements OnFocusChangeListener {
    final /* synthetic */ jd a;
    final /* synthetic */ Comment b;
    final /* synthetic */ int c;
    final /* synthetic */ he d;

    he$2(he this$0, jd jdVar, Comment comment, int i) {
        this.d = this$0;
        this.a = jdVar;
        this.b = comment;
        this.c = i;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            new Handler().post(new he$2$1(this));
        }
    }
}
