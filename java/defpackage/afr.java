package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.ArrayList;
import java.util.List;

public class afr implements Creator<PolygonOptions> {
    public static void a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int zzav = xw.zzav(parcel);
        xw.a(parcel, 1, polygonOptions.a());
        xw.c(parcel, 2, polygonOptions.c(), false);
        xw.d(parcel, 3, polygonOptions.b(), false);
        xw.a(parcel, 4, polygonOptions.d());
        xw.a(parcel, 5, polygonOptions.e());
        xw.a(parcel, 6, polygonOptions.f());
        xw.a(parcel, 7, polygonOptions.g());
        xw.a(parcel, 8, polygonOptions.h());
        xw.a(parcel, 9, polygonOptions.i());
        xw.a(parcel, 10, polygonOptions.j());
        xw.zzI(parcel, zzav);
    }

    public PolygonOptions a(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i3 = zza.f(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    list = zza.c(parcel, zzat, LatLng.CREATOR);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    zza.a(parcel, zzat, arrayList, getClass().getClassLoader());
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    f2 = zza.j(parcel, zzat);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    i2 = zza.f(parcel, zzat);
                    break;
                case uu$h.CardView_cardUseCompatPadding /*6*/:
                    i = zza.f(parcel, zzat);
                    break;
                case uu$h.CardView_cardPreventCornerOverlap /*7*/:
                    f = zza.j(parcel, zzat);
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    z3 = zza.c(parcel, zzat);
                    break;
                case uu$h.CardView_contentPaddingLeft /*9*/:
                    z2 = zza.c(parcel, zzat);
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    z = zza.c(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PolygonOptions[] a(int i) {
        return new PolygonOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
