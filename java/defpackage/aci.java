package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.DetectedActivity;

public class aci implements Creator<DetectedActivity> {
    public static void a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int zzav = xw.zzav(parcel);
        xw.a(parcel, 1, detectedActivity.c);
        xw.a(parcel, 1000, detectedActivity.c());
        xw.a(parcel, 2, detectedActivity.d);
        xw.zzI(parcel, zzav);
    }

    public DetectedActivity a(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i2 = zza.f(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    i = zza.f(parcel, zzat);
                    break;
                case 1000:
                    i3 = zza.f(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DetectedActivity[] a(int size) {
        return new DetectedActivity[size];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
