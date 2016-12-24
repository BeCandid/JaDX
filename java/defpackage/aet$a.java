package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class aet$a extends Binder implements aet {
    public static aet a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnPolylineClickListener");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aet)) ? new aet$a$a(iBinder) : (aet) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IOnPolylineClickListener");
                a(afb$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IOnPolylineClickListener");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
