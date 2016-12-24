package defpackage;

import android.app.Activity;
import android.content.Intent;

/* compiled from: LoginManager */
class wm$b implements wo {
    private final vq a;

    wm$b(vq fragment) {
        wf.a((Object) fragment, "fragment");
        this.a = fragment;
    }

    public void a(Intent intent, int requestCode) {
        this.a.a(intent, requestCode);
    }

    public Activity a() {
        return this.a.c();
    }
}
