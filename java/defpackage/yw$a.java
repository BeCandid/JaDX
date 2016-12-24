package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class yw$a extends Binder implements yw {
    public yw$a() {
        attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public static yw a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof yw)) ? new yw$a$a(iBinder) : (yw) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        Bundle bundle = null;
        int readInt;
        switch (i) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                readInt = parcel.readInt();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                a(readInt, readStrongBinder, bundle);
                parcel2.writeNoException();
                return true;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                a(readInt, bundle);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
