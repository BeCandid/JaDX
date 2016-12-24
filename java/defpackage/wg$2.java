package defpackage;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: WebDialog */
class wg$2 implements OnClickListener {
    final /* synthetic */ wg a;

    wg$2(wg this$0) {
        this.a = this$0;
    }

    public void onClick(View v) {
        this.a.cancel();
    }
}
