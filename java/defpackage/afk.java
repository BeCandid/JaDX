package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class afk implements Creator<CameraPosition> {
    public static void a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int zzav = xw.zzav(parcel);
        xw.a(parcel, 1, cameraPosition.a());
        xw.a(parcel, 2, cameraPosition.a, i, false);
        xw.a(parcel, 3, cameraPosition.b);
        xw.a(parcel, 4, cameraPosition.c);
        xw.a(parcel, 5, cameraPosition.d);
        xw.zzI(parcel, zzav);
    }

    public CameraPosition a(Parcel parcel) {
        float f = 0.0f;
        int zzau = zza.zzau(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
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
                    f3 = zza.j(parcel, zzat);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    f2 = zza.j(parcel, zzat);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    f = zza.j(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CameraPosition[] a(int i) {
        return new CameraPosition[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
