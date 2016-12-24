package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public abstract class aev$a extends Binder implements aev {
    public static aev a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aev)) ? new aev$a$a(iBinder) : (aev) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
                a(data.readInt() != 0 ? StreetViewPanoramaLocation.CREATOR.a(data) : null);
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
