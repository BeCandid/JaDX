package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zz implements Creator<ConnectionResult> {
    public static void a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = xw.a(parcel);
        xw.a(parcel, 1, connectionResult.b);
        xw.a(parcel, 2, connectionResult.c());
        xw.a(parcel, 3, connectionResult.d(), i, false);
        xw.a(parcel, 4, connectionResult.e(), false);
        xw.a(parcel, a);
    }

    public ConnectionResult a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = zza.b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = zza.a(parcel);
            String str3;
            switch (zza.a(a)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = zza.f(parcel, a);
                    str2 = str3;
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = zza.f(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) zza.a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str2 = zza.n(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    zza.b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
