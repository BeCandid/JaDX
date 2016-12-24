package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AlertDialog;

/* compiled from: ViewUtils */
class jb$1 implements OnClickListener {
    final /* synthetic */ in$a a;

    jb$1(in$a in_a) {
        this.a = in_a;
    }

    public void onClick(DialogInterface dialog, int which) {
        if (((AlertDialog) dialog).getListView() != null) {
            this.a.d = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
        }
        ix.a().a(this.a);
    }
}
