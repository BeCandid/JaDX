package defpackage;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class aei$a$a implements aei {
    private IBinder a;

    aei$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public void a(aag aag) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            obtain.writeStrongBinder(aag != null ? aag.asBinder() : null);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(Location location) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            if (location != null) {
                obtain.writeInt(1);
                location.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(2, obtain, obtain2, 0);
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
