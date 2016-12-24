package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class adq$a extends Binder implements adq {
    public static adq a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof adq)) ? new adq$a$a(iBinder) : (adq) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        IBinder iBinder = null;
        Bundle bundle;
        switch (code) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                ado a = a();
                reply.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                if (data.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                }
                a(bundle);
                reply.writeNoException();
                return true;
            case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                b();
                reply.writeNoException();
                return true;
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                c();
                reply.writeNoException();
                return true;
            case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                d();
                reply.writeNoException();
                return true;
            case uu$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                e();
                reply.writeNoException();
                return true;
            case uu$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                if (data.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                }
                b(bundle);
                reply.writeNoException();
                if (bundle != null) {
                    reply.writeInt(1);
                    bundle.writeToParcel(reply, 1);
                } else {
                    reply.writeInt(0);
                }
                return true;
            case uu$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                aag f = f();
                reply.writeNoException();
                if (f != null) {
                    iBinder = f.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case uu$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                a(adv$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
