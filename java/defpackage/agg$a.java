package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

public class agg$a implements ServiceConnection, yi$b, yi$c {
    final /* synthetic */ agg a;
    private volatile boolean b;
    private volatile ahc c;

    protected agg$a(agg agg) {
        this.a = agg;
    }

    public void a() {
        this.a.j();
        Context q = this.a.q();
        synchronized (this) {
            if (this.b) {
                this.a.w().E().a("Connection attempt already in progress");
            } else if (this.c != null) {
                this.a.w().E().a("Already awaiting connection attempt");
            } else {
                this.c = new ahc(q, Looper.getMainLooper(), this, this);
                this.a.w().E().a("Connecting to remote service");
                this.b = true;
                this.c.k();
            }
        }
    }

    public void a(int i) {
        xz.b("MeasurementServiceConnection.onConnectionSuspended");
        this.a.w().D().a("Service connection suspended");
        this.a.v().a(new agg$a$4(this));
    }

    public void a(Intent intent) {
        this.a.j();
        Context q = this.a.q();
        ze a = ze.a();
        synchronized (this) {
            if (this.b) {
                this.a.w().E().a("Connection attempt already in progress");
                return;
            }
            this.b = true;
            a.a(q, intent, this.a.a, 129);
        }
    }

    public void a(Bundle bundle) {
        xz.b("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                aha aha = (aha) this.c.r();
                this.c = null;
                this.a.v().a(new agg$a$3(this, aha));
            } catch (DeadObjectException e) {
                this.c = null;
                this.b = false;
            } catch (IllegalStateException e2) {
                this.c = null;
                this.b = false;
            }
        }
    }

    public void a(ConnectionResult connectionResult) {
        xz.b("MeasurementServiceConnection.onConnectionFailed");
        ahd g = this.a.n.g();
        if (g != null) {
            g.z().a("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.b = false;
            this.c = null;
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        xz.b("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.b = false;
                this.a.w().f().a("Service connected with null binder");
                return;
            }
            aha aha = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    aha = aha$a.a(iBinder);
                    this.a.w().E().a("Bound to IMeasurementService interface");
                } else {
                    this.a.w().f().a("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException e) {
                this.a.w().f().a("Service connect failed to get IMeasurementService");
            }
            if (aha == null) {
                this.b = false;
                try {
                    ze.a().a(this.a.q(), this.a.a);
                } catch (IllegalArgumentException e2) {
                }
            } else {
                this.a.v().a(new agg$a$1(this, aha));
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        xz.b("MeasurementServiceConnection.onServiceDisconnected");
        this.a.w().D().a("Service disconnected");
        this.a.v().a(new agg$a$2(this, componentName));
    }
}
