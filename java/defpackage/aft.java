package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class aft implements Creator<StreetViewPanoramaCamera> {
    public static void a(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int i) {
        int zzav = xw.zzav(parcel);
        xw.a(parcel, 1, streetViewPanoramaCamera.a());
        xw.a(parcel, 2, streetViewPanoramaCamera.a);
        xw.a(parcel, 3, streetViewPanoramaCamera.b);
        xw.a(parcel, 4, streetViewPanoramaCamera.c);
        xw.zzI(parcel, zzav);
    }

    public StreetViewPanoramaCamera a(Parcel parcel) {
        float f = 0.0f;
        int zzau = zza.zzau(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    f2 = zza.j(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    f3 = zza.j(parcel, zzat);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    f = zza.j(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new StreetViewPanoramaCamera(i, f2, f3, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StreetViewPanoramaCamera[] a(int i) {
        return new StreetViewPanoramaCamera[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
