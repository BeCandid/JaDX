package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class aeb$a extends Binder implements aeb {
    public static aeb a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aeb)) ? new aeb$a$a(iBinder) : (aeb) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        IBinder iBinder = null;
        aag a;
        switch (code) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                a = a(afg$a.a(data.readStrongBinder()));
                reply.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                a = b(afg$a.a(data.readStrongBinder()));
                reply.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
