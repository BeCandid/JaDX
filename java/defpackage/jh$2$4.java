package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.support.v7.app.AlertDialog;

/* compiled from: MessageViewHolder */
class jh$2$4 implements OnShowListener {
    final /* synthetic */ int[] a;
    final /* synthetic */ jh$2 b;

    jh$2$4(jh$2 this$0, int[] iArr) {
        this.b = this$0;
        this.a = iArr;
    }

    public void onShow(DialogInterface dialog) {
        if (this.a[0] < 0) {
            ((AlertDialog) dialog).getButton(-1).setEnabled(false);
        }
    }
}
