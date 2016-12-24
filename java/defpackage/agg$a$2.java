package defpackage;

import android.content.ComponentName;

class agg$a$2 implements Runnable {
    final /* synthetic */ ComponentName a;
    final /* synthetic */ agg$a b;

    agg$a$2(agg$a agg_a, ComponentName componentName) {
        this.b = agg_a;
        this.a = componentName;
    }

    public void run() {
        this.b.a.a(this.a);
    }
}
