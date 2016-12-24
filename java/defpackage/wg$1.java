package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: WebDialog */
class wg$1 implements OnCancelListener {
    final /* synthetic */ wg a;

    wg$1(wg this$0) {
        this.a = this$0;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.cancel();
    }
}
