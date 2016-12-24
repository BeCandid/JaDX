package defpackage;

import android.os.Bundle;
import android.os.Parcelable;

public final class adx {
    private adx() {
    }

    public static void a(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(adx.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(adx.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
