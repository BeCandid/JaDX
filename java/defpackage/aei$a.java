package defpackage;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class aei$a extends Binder implements aei {
    public static aei a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aei)) ? new aei$a$a(iBinder) : (aei) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                a((aag) aag$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                a(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null);
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
