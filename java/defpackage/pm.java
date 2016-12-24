package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: DefaultConnectivityMonitor */
class pm implements pk {
    private final Context a;
    private final pk$a b;
    private boolean c;
    private boolean d;
    private final BroadcastReceiver e = new pm$1(this);

    public pm(Context context, pk$a listener) {
        this.a = context.getApplicationContext();
        this.b = listener;
    }

    private void a() {
        if (!this.d) {
            this.c = a(this.a);
            this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.d = true;
        }
    }

    private void b() {
        if (this.d) {
            this.a.unregisterReceiver(this.e);
            this.d = false;
        }
    }

    private boolean a(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public void onStart() {
        a();
    }

    public void onStop() {
        b();
    }

    public void onDestroy() {
    }
}
