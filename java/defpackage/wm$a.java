package defpackage;

import android.app.Activity;
import android.content.Intent;

/* compiled from: LoginManager */
class wm$a implements wo {
    private final Activity a;

    wm$a(Activity activity) {
        wf.a((Object) activity, "activity");
        this.a = activity;
    }

    public void a(Intent intent, int requestCode) {
        this.a.startActivityForResult(intent, requestCode);
    }

    public Activity a() {
        return this.a;
    }
}
