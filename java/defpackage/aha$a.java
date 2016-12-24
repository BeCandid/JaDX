package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.List;

public abstract class aha$a extends Binder implements aha {
    public aha$a() {
        attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public static aha a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aha)) ? new aha$a$a(iBinder) : (aha) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                a(parcel.readInt() != 0 ? (EventParcel) EventParcel.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                a(parcel.readInt() != 0 ? (UserAttributeParcel) UserAttributeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                a(parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                a(parcel.readInt() != 0 ? (EventParcel) EventParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case uu$h.CardView_cardUseCompatPadding /*6*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                b(parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case uu$h.CardView_cardPreventCornerOverlap /*7*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                List a = a(parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeTypedList(a);
                return true;
            case uu$h.CardView_contentPaddingLeft /*9*/:
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                byte[] a2 = a(parcel.readInt() != 0 ? (EventParcel) EventParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(a2);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
