package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class adv$a$a implements adv {
    private IBinder a;

    adv$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public void a(ado ado) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            obtain.writeStrongBinder(ado != null ? ado.asBinder() : null);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}
