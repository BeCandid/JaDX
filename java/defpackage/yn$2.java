package defpackage;

import android.content.Intent;
import android.support.v4.app.Fragment;

class yn$2 extends yn {
    final /* synthetic */ Fragment a;
    final /* synthetic */ Intent b;
    final /* synthetic */ int c;

    yn$2(Fragment fragment, Intent intent, int i) {
        this.a = fragment;
        this.b = intent;
        this.c = i;
    }

    public void a() {
        this.a.startActivityForResult(this.b, this.c);
    }
}
