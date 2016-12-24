package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DefaultConnectivityMonitor */
class pm$1 extends BroadcastReceiver {
    final /* synthetic */ pm a;

    pm$1(pm pmVar) {
        this.a = pmVar;
    }

    public void onReceive(Context context, Intent intent) {
        boolean wasConnected = this.a.c;
        this.a.c = this.a.a(context);
        if (wasConnected != this.a.c) {
            this.a.b.a(this.a.c);
        }
    }
}
