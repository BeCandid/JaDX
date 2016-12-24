package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.signin.internal.SignInRequest;

public class aht implements Creator<SignInRequest> {
    public static void a(SignInRequest signInRequest, Parcel parcel, int i) {
        int a = xw.a(parcel);
        xw.a(parcel, 1, signInRequest.a);
        xw.a(parcel, 2, signInRequest.a(), i, false);
        xw.a(parcel, a);
    }

    public SignInRequest a(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    resolveAccountRequest = (ResolveAccountRequest) zza.a(parcel, a, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public SignInRequest[] a(int i) {
        return new SignInRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
