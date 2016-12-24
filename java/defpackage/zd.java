package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.stats.ConnectionEvent;

public class zd implements Creator<ConnectionEvent> {
    public static void a(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int a = xw.a(parcel);
        xw.a(parcel, 1, connectionEvent.a);
        xw.a(parcel, 2, connectionEvent.a());
        xw.a(parcel, 4, connectionEvent.c(), false);
        xw.a(parcel, 5, connectionEvent.d(), false);
        xw.a(parcel, 6, connectionEvent.e(), false);
        xw.a(parcel, 7, connectionEvent.f(), false);
        xw.a(parcel, 8, connectionEvent.g(), false);
        xw.a(parcel, 10, connectionEvent.k());
        xw.a(parcel, 11, connectionEvent.j());
        xw.a(parcel, 12, connectionEvent.b());
        xw.a(parcel, 13, connectionEvent.h(), false);
        xw.a(parcel, a);
    }

    public ConnectionEvent a(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case uu$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case uu$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    j = zza.h(parcel, a);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str = zza.n(parcel, a);
                    break;
                case uu$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    str2 = zza.n(parcel, a);
                    break;
                case uu$h.CardView_cardUseCompatPadding /*6*/:
                    str3 = zza.n(parcel, a);
                    break;
                case uu$h.CardView_cardPreventCornerOverlap /*7*/:
                    str4 = zza.n(parcel, a);
                    break;
                case uu$h.CardView_contentPadding /*8*/:
                    str5 = zza.n(parcel, a);
                    break;
                case uu$h.CardView_contentPaddingRight /*10*/:
                    j2 = zza.h(parcel, a);
                    break;
                case uu$h.CardView_contentPaddingTop /*11*/:
                    j3 = zza.h(parcel, a);
                    break;
                case uu$h.CardView_contentPaddingBottom /*12*/:
                    i2 = zza.f(parcel, a);
                    break;
                case ha$a.Toolbar_titleMarginStart /*13*/:
                    str6 = zza.n(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public ConnectionEvent[] a(int i) {
        return new ConnectionEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
