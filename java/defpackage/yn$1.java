package defpackage;

import android.app.Activity;
import android.content.Intent;

class yn$1 extends yn {
    final /* synthetic */ Activity a;
    final /* synthetic */ Intent b;
    final /* synthetic */ int c;

    yn$1(Activity activity, Intent intent, int i) {
        this.a = activity;
        this.b = intent;
        this.c = i;
    }

    public void a() {
        this.a.startActivityForResult(this.b, this.c);
    }
}
