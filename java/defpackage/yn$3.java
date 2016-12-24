package defpackage;

import android.annotation.TargetApi;
import android.content.Intent;

class yn$3 extends yn {
    final /* synthetic */ abj a;
    final /* synthetic */ Intent b;
    final /* synthetic */ int c;

    yn$3(abj abj, Intent intent, int i) {
        this.a = abj;
        this.b = intent;
        this.c = i;
    }

    @TargetApi(11)
    public void a() {
        this.a.startActivityForResult(this.b, this.c);
    }
}
