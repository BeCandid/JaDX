package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class afp implements Creator<MarkerOptions> {
    public static void a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int zzav = xw.zzav(parcel);
        xw.a(parcel, 1, markerOptions.a());
        xw.a(parcel, 2, markerOptions.c(), i, false);
        xw.a(parcel, 3, markerOptions.d(), false);
        xw.a(parcel, 4, markerOptions.e(), false);
        xw.a(parcel, 5, markerOptions.b(), false);
        xw.a(parcel, 6, markerOptions.f());
        xw.a(parcel, 7, markerOptions.g());
        xw.a(parcel, 8, markerOptions.h());
        xw.a(parcel, 9, markerOptions.i());
        xw.a(parcel, 10, markerOptions.j());
        xw.a(parcel, 11, markerOptions.k());
        xw.a(parcel, 12, markerOptions.l());
        xw.a(parcel, 13, markerOptions.m());
        xw.a(parcel, 14, markerOptions.n());
        xw.zzI(parcel, zzav);
    }

    public MarkerOptions a(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    latLng = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case uu$h.CardView_cardUseCompatPadding /*6*/:
                    f = zza.j(parcel, zzat);
                    break;
                case uu$h.CardView_cardPreventCornerOverlap /*7*/:
                    f2 = zza.j(parcel, zzat);
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    z = zza.c(parcel, zzat);
                    break;
                case uu$h.CardView_contentPaddingLeft /*9*/:
                    z2 = zza.c(parcel, zzat);
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    z3 = zza.c(parcel, zzat);
                    break;
                case uu$h.CardView_contentPaddingTop /*11*/:
                    f3 = zza.j(parcel, zzat);
                    break;
                case uu$h.CardView_contentPaddingBottom /*12*/:
                    f4 = zza.j(parcel, zzat);
                    break;
                case ha$a.Toolbar_titleMarginStart /*13*/:
                    f5 = zza.j(parcel, zzat);
                    break;
                case ha$a.Toolbar_titleMarginEnd /*14*/:
                    f6 = zza.j(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MarkerOptions[] a(int i) {
        return new MarkerOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
