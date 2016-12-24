package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class yr$b$a implements ServiceConnection {
    final /* synthetic */ yr$b a;

    public yr$b$a(yr$b yr_b) {
        this.a = yr_b;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (yr.a(this.a.a)) {
            this.a.f = iBinder;
            this.a.h = componentName;
            for (ServiceConnection onServiceConnected : this.a.c) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.a.d = 1;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (yr.a(this.a.a)) {
            this.a.f = null;
            this.a.h = componentName;
            for (ServiceConnection onServiceDisconnected : this.a.c) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.a.d = 2;
        }
    }
}
