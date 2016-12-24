package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class aep$a extends Binder implements aep {
    public static aep a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aep)) ? new aep$a$a(iBinder) : (aep) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                boolean a = a();
                reply.writeNoException();
                reply.writeInt(a ? 1 : 0);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
