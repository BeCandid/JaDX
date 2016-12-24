package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.List;

public class ach implements Creator<ActivityRecognitionResult> {
    public static void a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int zzav = xw.zzav(parcel);
        xw.c(parcel, 1, activityRecognitionResult.a, false);
        xw.a(parcel, 1000, activityRecognitionResult.b());
        xw.a(parcel, 2, activityRecognitionResult.b);
        xw.a(parcel, 3, activityRecognitionResult.c);
        xw.a(parcel, 4, activityRecognitionResult.d);
        xw.a(parcel, 5, activityRecognitionResult.e, false);
        xw.zzI(parcel, zzav);
    }

    public ActivityRecognitionResult a(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        long j2 = 0;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    list = zza.c(parcel, zzat, DetectedActivity.CREATOR);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    j2 = zza.h(parcel, zzat);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    j = zza.h(parcel, zzat);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    i = zza.f(parcel, zzat);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.f(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ActivityRecognitionResult(i2, list, j2, j, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ActivityRecognitionResult[] a(int size) {
        return new ActivityRecognitionResult[size];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
