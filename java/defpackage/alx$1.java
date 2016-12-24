package defpackage;

import android.content.Context;

/* compiled from: InstallerPackageNameProvider */
class alx$1 implements alk<String> {
    final /* synthetic */ alx a;

    alx$1(alx alx) {
        this.a = alx;
    }

    public /* synthetic */ Object b(Context x0) throws Exception {
        return a(x0);
    }

    public String a(Context context) throws Exception {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }
}
