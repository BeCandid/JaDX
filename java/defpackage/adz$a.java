package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class adz$a extends Binder implements adz {
    public static adz a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICancelableCallback");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof adz)) ? new adz$a$a(iBinder) : (adz) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ICancelableCallback");
                a();
                reply.writeNoException();
                return true;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ICancelableCallback");
                b();
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.ICancelableCallback");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
