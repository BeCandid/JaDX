package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: CrashlyticsCore */
class sz$7$1 implements OnClickListener {
    final /* synthetic */ sz$7 a;

    sz$7$1(sz$7 sz_7) {
        this.a = sz_7;
    }

    public void onClick(DialogInterface dialog, int which) {
        this.a.b.a(true);
        dialog.dismiss();
    }
}
