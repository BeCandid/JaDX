package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.SignInButtonConfig;

public abstract class yz$a extends Binder implements yz {
    public static yz a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof yz)) ? new yz$a$a(iBinder) : (yz) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IBinder iBinder = null;
        aag a;
        switch (i) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                a = a(aag$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                a = a(aag$a.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (SignInButtonConfig) SignInButtonConfig.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
