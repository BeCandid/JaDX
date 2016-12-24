package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class aeg$a$a implements aeg {
    private IBinder a;

    aeg$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public void a(afg afg) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnInfoWindowCloseListener");
            obtain.writeStrongBinder(afg != null ? afg.asBinder() : null);
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
