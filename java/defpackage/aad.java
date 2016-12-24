package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;

public class aad {
    private static aad a;
    private final Context b;

    private aad(Context context) {
        this.b = context.getApplicationContext();
    }

    public static aad a(Context context) {
        xz.a((Object) context);
        synchronized (aad.class) {
            if (a == null) {
                aab.a(context);
                a = new aad(context);
            }
        }
        return a;
    }

    aab$a a(PackageInfo packageInfo, aab$a... aab_aArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        aab$a aab_b = new aab$b(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < aab_aArr.length; i++) {
            if (aab_aArr[i].equals(aab_b)) {
                return aab_aArr[i];
            }
        }
        String valueOf = String.valueOf(packageInfo.packageName);
        String valueOf2 = String.valueOf(Base64.encodeToString(aab_b.c(), 0));
        Log.v("GoogleSignatureVerifier", new StringBuilder((String.valueOf(valueOf).length() + 31) + String.valueOf(valueOf2).length()).append(valueOf).append(" signature not valid.  Found: \n").append(valueOf2).toString());
        return null;
    }

    public boolean a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            aab$a a;
            if (z) {
                a = a(packageInfo, aab$d.a);
            } else {
                a = a(packageInfo, aab$d.a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (aac.zzal(this.b)) {
            return a(packageInfo, true);
        }
        boolean a = a(packageInfo, false);
        if (a || !a(packageInfo, true)) {
            return a;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return a;
    }
}
