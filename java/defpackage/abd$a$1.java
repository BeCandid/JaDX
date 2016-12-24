package defpackage;

import android.app.Dialog;
import com.google.android.gms.internal.zzol.a;

class abd$a$1 extends a {
    final /* synthetic */ Dialog a;
    final /* synthetic */ abd$a b;

    abd$a$1(abd$a abd_a, Dialog dialog) {
        this.b = abd_a;
        this.a = dialog;
    }

    public void a() {
        this.b.a.d();
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
