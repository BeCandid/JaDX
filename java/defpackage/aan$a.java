package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class aan$a extends Binder implements aan {
    public aan$a() {
        attachInterface(this, "com.google.android.gms.iid.IMessengerCompat");
    }

    public static aan a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aan)) ? new aan$a$a(iBinder) : (aan) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                parcel.enforceInterface("com.google.android.gms.iid.IMessengerCompat");
                a(parcel.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.iid.IMessengerCompat");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
