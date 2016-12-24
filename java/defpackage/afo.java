package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;

public class afo implements Creator<LatLng> {
    public static void a(LatLng latLng, Parcel parcel, int i) {
        int zzav = xw.zzav(parcel);
        xw.a(parcel, 1, latLng.a());
        xw.a(parcel, 2, latLng.a);
        xw.a(parcel, 3, latLng.b);
        xw.zzI(parcel, zzav);
    }

    public LatLng a(Parcel parcel) {
        double d = 0.0d;
        int zzau = zza.zzau(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    d2 = zza.l(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    d = zza.l(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LatLng(i, d2, d);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LatLng[] a(int i) {
        return new LatLng[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
