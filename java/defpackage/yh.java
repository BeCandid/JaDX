package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

public class yh implements Creator<AuthAccountRequest> {
    public static void a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int a = xw.a(parcel);
        xw.a(parcel, 1, authAccountRequest.a);
        xw.a(parcel, 2, authAccountRequest.b, false);
        xw.a(parcel, 3, authAccountRequest.c, i, false);
        xw.a(parcel, 4, authAccountRequest.d, false);
        xw.a(parcel, 5, authAccountRequest.e, false);
        xw.a(parcel, a);
    }

    public AuthAccountRequest a(Parcel parcel) {
        Integer num = null;
        int b = zza.b(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    iBinder = zza.o(parcel, a);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    scopeArr = (Scope[]) zza.b(parcel, a, Scope.CREATOR);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    num2 = zza.g(parcel, a);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    num = zza.g(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountRequest[] a(int i) {
        return new AuthAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
