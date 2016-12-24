package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

class aea$a$a implements aea {
    private IBinder a;

    aea$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public adi a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            adi a = adi$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public adm a(aag aag, GoogleMapOptions googleMapOptions) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(aag != null ? aag.asBinder() : null);
            if (googleMapOptions != null) {
                obtain.writeInt(1);
                googleMapOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            adm a = adm$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public adq a(aag aag, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(aag != null ? aag.asBinder() : null);
            if (streetViewPanoramaOptions != null) {
                obtain.writeInt(1);
                streetViewPanoramaOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            adq a = adq$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(aag resources) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(resources != null ? resources.asBinder() : null);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(aag aag, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(aag != null ? aag.asBinder() : null);
            obtain.writeInt(i);
            this.a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    public adl b(aag aag) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(aag != null ? aag.asBinder() : null);
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            adl a = adl$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public afc b() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            afc a = afc$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public adp c(aag aag) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(aag != null ? aag.asBinder() : null);
            this.a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            adp a = adp$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
