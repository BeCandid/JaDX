package defpackage;

import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: VersionedGestureDetector */
public final class ati {
    public static atg a(Context context, ath listener) {
        atg detector;
        int sdkVersion = VERSION.SDK_INT;
        if (sdkVersion < 5) {
            detector = new atd(context);
        } else if (sdkVersion < 8) {
            detector = new ate(context);
        } else {
            detector = new atf(context);
        }
        detector.a(listener);
        return detector;
    }
}
