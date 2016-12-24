package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class xx {
    public static <T extends SafeParcelable> T a(Intent intent, String str, Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        return byteArrayExtra == null ? null : xx.a(byteArrayExtra, creator);
    }

    public static <T extends SafeParcelable> T a(byte[] bArr, Creator<T> creator) {
        xz.a((Object) creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
