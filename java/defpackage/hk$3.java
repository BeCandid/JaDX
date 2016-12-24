package defpackage;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MeSettingsAdapter */
class hk$3 implements OnClickListener {
    final /* synthetic */ hk a;

    hk$3(hk this$0) {
        this.a = this$0;
    }

    public void onClick(View v) {
        new Builder(this.a.d).setIconAttribute(16843605).setTitle("Disown this account?").setMessage("Once you disconnect you can never log in to this account again.").setPositiveButton("Yes", new hk$3$1(this)).setNegativeButton("No", null).show();
    }
}
