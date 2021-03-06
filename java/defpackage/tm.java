package defpackage;

import android.content.Context;
import android.os.Bundle;

/* compiled from: ManifestUnityVersionProvider */
class tm implements tv {
    private final Context a;
    private final String b;

    public tm(Context context, String packageName) {
        this.a = context;
        this.b = packageName;
    }

    public String a() {
        String unityVersion = null;
        try {
            Bundle metaData = this.a.getPackageManager().getApplicationInfo(this.b, 128).metaData;
            if (metaData != null) {
                unityVersion = metaData.getString("io.fabric.unity.crashlytics.version");
            }
        } catch (Exception e) {
        }
        return unityVersion;
    }
}
