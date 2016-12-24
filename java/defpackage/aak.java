package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

public class aak {
    private static SharedPreferences a = null;

    public static SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (a == null) {
                a = (SharedPreferences) abx.a(new aak$1(context));
            }
            sharedPreferences = a;
        }
        return sharedPreferences;
    }
}
