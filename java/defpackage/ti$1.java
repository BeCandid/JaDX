package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DevicePowerStateListener */
class ti$1 extends BroadcastReceiver {
    final /* synthetic */ ti a;

    ti$1(ti tiVar) {
        this.a = tiVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.h = true;
    }
}
