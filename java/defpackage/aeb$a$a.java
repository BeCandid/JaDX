package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class aeb$a$a implements aeb {
    private IBinder a;

    aeb$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public aag a(afg afg) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            obtain.writeStrongBinder(afg != null ? afg.asBinder() : null);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            aag zzbs = aag$a.zzbs(obtain2.readStrongBinder());
            return zzbs;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    public aag b(afg afg) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            obtain.writeStrongBinder(afg != null ? afg.asBinder() : null);
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            aag zzbs = aag$a.zzbs(obtain2.readStrongBinder());
            return zzbs;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
