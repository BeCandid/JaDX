package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.becandid.candid.activities.MeSettingsActivity;

/* compiled from: MeSettingsAdapter */
class hk$3$1 implements OnClickListener {
    final /* synthetic */ hk$3 a;

    hk$3$1(hk$3 this$1) {
        this.a = this$1;
    }

    public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
        ((MeSettingsActivity) this.a.a.d).disownAccount();
    }
}
