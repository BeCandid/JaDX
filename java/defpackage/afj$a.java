package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public abstract class afj$a extends Binder implements afj {
    public static afj a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof afj)) ? new afj$a$a(iBinder) : (afj) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                Tile a = a(data.readInt(), data.readInt(), data.readInt());
                reply.writeNoException();
                if (a != null) {
                    reply.writeInt(1);
                    a.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
