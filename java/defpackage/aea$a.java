package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public abstract class aea$a extends Binder implements aea {
    public static aea a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aea)) ? new aea$a$a(iBinder) : (aea) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        IBinder iBinder = null;
        switch (code) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                a(aag$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                adl b = b(aag$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                if (b != null) {
                    iBinder = b.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                adm a = a((aag) aag$a.zzbs(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.a(data) : null);
                reply.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                adi a2 = a();
                reply.writeNoException();
                if (a2 != null) {
                    iBinder = a2.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                afc b2 = b();
                reply.writeNoException();
                if (b2 != null) {
                    iBinder = b2.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case uu$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                a((aag) aag$a.zzbs(data.readStrongBinder()), data.readInt());
                reply.writeNoException();
                return true;
            case uu$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                adq a3 = a((aag) aag$a.zzbs(data.readStrongBinder()), data.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.a(data) : null);
                reply.writeNoException();
                if (a3 != null) {
                    iBinder = a3.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case uu$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                adp c = c(aag$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                if (c != null) {
                    iBinder = c.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.ICreator");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
