package defpackage;

import android.content.Context;

/* compiled from: InstallerPackageNameProvider */
public class alx {
    private final alk<String> a = new alx$1(this);
    private final ali<String> b = new ali();

    public String a(Context appContext) {
        try {
            String name = (String) this.b.a(appContext, this.a);
            if ("".equals(name)) {
                return null;
            }
            return name;
        } catch (Exception e) {
            akx.h().e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
