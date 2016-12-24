package defpackage;

import android.content.Context;

/* compiled from: ConnectivityMonitorFactory */
public class pl {
    public pk a(Context context, pk$a listener) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            return new pm(context, listener);
        }
        return new pq();
    }
}
