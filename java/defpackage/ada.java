package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.AutocompleteFilter;
import java.util.List;

public class ada implements Creator<AutocompleteFilter> {
    public static void a(AutocompleteFilter autocompleteFilter, Parcel parcel, int i) {
        int zzav = xw.zzav(parcel);
        xw.a(parcel, 1, autocompleteFilter.b);
        xw.a(parcel, 1000, autocompleteFilter.a);
        xw.a(parcel, 2, autocompleteFilter.c, false);
        xw.zzI(parcel, zzav);
    }

    public AutocompleteFilter a(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    z = zza.c(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    list = zza.zzC(parcel, zzat);
                    break;
                case 1000:
                    i = zza.f(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AutocompleteFilter(i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AutocompleteFilter[] a(int i) {
        return new AutocompleteFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
