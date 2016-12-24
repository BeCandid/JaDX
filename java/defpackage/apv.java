package defpackage;

import android.os.Handler;
import android.os.Looper;

/* compiled from: AndroidSchedulers */
public final class apv {
    private static final apo a = new apw(new Handler(Looper.getMainLooper()));

    public static apo a() {
        apo scheduler = apt.a().b().b();
        return scheduler != null ? scheduler : a;
    }
}
