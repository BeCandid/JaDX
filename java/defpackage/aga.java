package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;

public class aga implements Creator<GoogleMapOptions> {
    public static void a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int zzav = xw.zzav(parcel);
        xw.a(parcel, 1, googleMapOptions.a());
        xw.a(parcel, 2, googleMapOptions.b());
        xw.a(parcel, 3, googleMapOptions.c());
        xw.a(parcel, 4, googleMapOptions.m());
        xw.a(parcel, 5, googleMapOptions.n(), i, false);
        xw.a(parcel, 6, googleMapOptions.d());
        xw.a(parcel, 7, googleMapOptions.e());
        xw.a(parcel, 8, googleMapOptions.f());
        xw.a(parcel, 9, googleMapOptions.g());
        xw.a(parcel, 10, googleMapOptions.h());
        xw.a(parcel, 11, googleMapOptions.i());
        xw.a(parcel, 12, googleMapOptions.j());
        xw.a(parcel, 14, googleMapOptions.k());
        xw.a(parcel, 15, googleMapOptions.l());
        xw.zzI(parcel, zzav);
    }

    public GoogleMapOptions a(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        byte b = (byte) -1;
        byte b2 = (byte) -1;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b3 = (byte) -1;
        byte b4 = (byte) -1;
        byte b5 = (byte) -1;
        byte b6 = (byte) -1;
        byte b7 = (byte) -1;
        byte b8 = (byte) -1;
        byte b9 = (byte) -1;
        byte b10 = (byte) -1;
        byte b11 = (byte) -1;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    b = zza.d(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    b2 = zza.d(parcel, zzat);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    i2 = zza.f(parcel, zzat);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    cameraPosition = (CameraPosition) zza.a(parcel, zzat, CameraPosition.CREATOR);
                    break;
                case uu$h.CardView_cardUseCompatPadding /*6*/:
                    b3 = zza.d(parcel, zzat);
                    break;
                case uu$h.CardView_cardPreventCornerOverlap /*7*/:
                    b4 = zza.d(parcel, zzat);
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    b5 = zza.d(parcel, zzat);
                    break;
                case uu$h.CardView_contentPaddingLeft /*9*/:
                    b6 = zza.d(parcel, zzat);
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    b7 = zza.d(parcel, zzat);
                    break;
                case uu$h.CardView_contentPaddingTop /*11*/:
                    b8 = zza.d(parcel, zzat);
                    break;
                case uu$h.CardView_contentPaddingBottom /*12*/:
                    b9 = zza.d(parcel, zzat);
                    break;
                case ha$a.Toolbar_titleMarginEnd /*14*/:
                    b10 = zza.d(parcel, zzat);
                    break;
                case ha$a.Toolbar_titleMarginTop /*15*/:
                    b11 = zza.d(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GoogleMapOptions(i, b, b2, i2, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10, b11);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GoogleMapOptions[] a(int i) {
        return new GoogleMapOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
