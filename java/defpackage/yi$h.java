package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class yi$h implements ServiceConnection {
    final /* synthetic */ yi a;
    private final int b;

    public yi$h(yi yiVar, int i) {
        this.a = yiVar;
        this.b = i;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        xz.a((Object) iBinder, (Object) "Expecting a valid IBinder");
        synchronized (this.a.n) {
            this.a.o = yx$a.a(iBinder);
        }
        this.a.a(0, null, this.b);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a.n) {
            this.a.o = null;
        }
        this.a.a.sendMessage(this.a.a.obtainMessage(4, this.b, 1));
    }
}
