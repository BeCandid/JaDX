package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;

/* compiled from: Answers */
public class rk extends alc<Boolean> {
    sf a;

    protected /* synthetic */ Object f() {
        return e();
    }

    public static rk c() {
        return (rk) akx.a(rk.class);
    }

    public void a(ru event) {
        if (event == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.a != null) {
            this.a.a(event);
        }
    }

    public void a(sk event) {
        if (event == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.a != null) {
            this.a.a((rz) event);
        }
    }

    public void a(alt$b exception) {
        if (this.a != null) {
            this.a.a(exception.a());
        }
    }

    public void a(alt$a exception) {
        if (this.a != null) {
            this.a.a(exception.a(), exception.b());
        }
    }

    @SuppressLint({"NewApi"})
    protected boolean a_() {
        try {
            long installedAt;
            Context context = E();
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String versionCode = Integer.toString(packageInfo.versionCode);
            String versionName = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                installedAt = packageInfo.firstInstallTime;
            } else {
                installedAt = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.a = sf.a(this, context, D(), versionCode, versionName, installedAt);
            this.a.b();
            return true;
        } catch (Exception e) {
            akx.h().e("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    protected Boolean e() {
        try {
            aoc settingsData = aoa.a().b();
            if (settingsData == null) {
                akx.h().e("Answers", "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (settingsData.d.d) {
                akx.h().a("Answers", "Analytics collection enabled");
                this.a.a(settingsData.e, g());
                return Boolean.valueOf(true);
            } else {
                akx.h().a("Answers", "Analytics collection disabled");
                this.a.c();
                return Boolean.valueOf(false);
            }
        } catch (Exception e) {
            akx.h().e("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    public String b() {
        return "com.crashlytics.sdk.android:answers";
    }

    public String a() {
        return "1.3.8.127";
    }

    String g() {
        return CommonUtils.b(E(), "com.crashlytics.ApiEndpoint");
    }
}
