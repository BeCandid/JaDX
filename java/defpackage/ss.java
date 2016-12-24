package defpackage;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: DeviceTokenLoader */
public class ss implements alk<String> {
    public /* synthetic */ Object b(Context x0) throws Exception {
        return a(x0);
    }

    public String a(Context context) throws Exception {
        long start = System.nanoTime();
        String token = "";
        ZipInputStream zis = null;
        try {
            zis = a(context, "io.crash.air");
            token = a(zis);
            if (zis != null) {
                try {
                    zis.close();
                } catch (IOException e) {
                    akx.h().e("Beta", "Failed to close the APK file", e);
                }
            }
        } catch (NameNotFoundException e2) {
            akx.h().a("Beta", "Beta by Crashlytics app is not installed");
            if (zis != null) {
                try {
                    zis.close();
                } catch (IOException e3) {
                    akx.h().e("Beta", "Failed to close the APK file", e3);
                }
            }
        } catch (FileNotFoundException e4) {
            akx.h().e("Beta", "Failed to find the APK file", e4);
            if (zis != null) {
                try {
                    zis.close();
                } catch (IOException e32) {
                    akx.h().e("Beta", "Failed to close the APK file", e32);
                }
            }
        } catch (IOException e322) {
            akx.h().e("Beta", "Failed to read the APK file", e322);
            if (zis != null) {
                try {
                    zis.close();
                } catch (IOException e3222) {
                    akx.h().e("Beta", "Failed to close the APK file", e3222);
                }
            }
        } catch (Throwable th) {
            if (zis != null) {
                try {
                    zis.close();
                } catch (IOException e32222) {
                    akx.h().e("Beta", "Failed to close the APK file", e32222);
                }
            }
        }
        akx.h().a("Beta", "Beta device token load took " + (((double) (System.nanoTime() - start)) / 1000000.0d) + "ms");
        return token;
    }

    ZipInputStream a(Context context, String packageName) throws NameNotFoundException, FileNotFoundException {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(packageName, 0).sourceDir));
    }

    String a(ZipInputStream zis) throws IOException {
        ZipEntry entry = zis.getNextEntry();
        if (entry != null) {
            String name = entry.getName();
            if (name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token=")) {
                return name.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), name.length() - 1);
            }
        }
        return "";
    }
}
