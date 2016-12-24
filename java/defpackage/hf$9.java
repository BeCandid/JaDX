package defpackage;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FeedAdapter */
class hf$9 implements OnClickListener {
    final /* synthetic */ jc a;
    final /* synthetic */ hf b;

    hf$9(hf this$0, jc jcVar) {
        this.b = this$0;
        this.a = jcVar;
    }

    public void onClick(View v) {
        ((je) this.a).itemView.findViewById(2131624388).setVisibility(0);
        v.setVisibility(8);
        this.b.g.onErrorRetry(this.b.a());
    }
}
