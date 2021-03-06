package defpackage;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ahl extends aha$a {
    private final ahk a;
    private final boolean b;

    public ahl(ahk ahk) {
        xz.a((Object) ahk);
        this.a = ahk;
        this.b = false;
    }

    public ahl(ahk ahk, boolean z) {
        xz.a((Object) ahk);
        this.a = ahk;
        this.b = z;
    }

    private void c(AppMetadata appMetadata) {
        xz.a((Object) appMetadata);
        c(appMetadata.b);
        this.a.n().f(appMetadata.c);
    }

    private void c(String str) throws SecurityException {
        if (TextUtils.isEmpty(str)) {
            this.a.f().f().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            b(str);
        } catch (SecurityException e) {
            this.a.f().f().a("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    public List<UserAttributeParcel> a(AppMetadata appMetadata, boolean z) {
        Object e;
        c(appMetadata);
        try {
            List<agn> list = (List) this.a.h().a(new ahl$7(this, appMetadata)).get();
            List<UserAttributeParcel> arrayList = new ArrayList(list.size());
            for (agn agn : list) {
                if (z || !ago.j(agn.b)) {
                    arrayList.add(new UserAttributeParcel(agn));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.a.f().f().a("Failed to get user attributes", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.a.f().f().a("Failed to get user attributes", e);
            return null;
        }
    }

    public void a(AppMetadata appMetadata) {
        c(appMetadata);
        this.a.h().a(new ahl$8(this, appMetadata));
    }

    public void a(EventParcel eventParcel, AppMetadata appMetadata) {
        xz.a((Object) eventParcel);
        c(appMetadata);
        this.a.h().a(new ahl$2(this, appMetadata, eventParcel));
    }

    public void a(EventParcel eventParcel, String str, String str2) {
        xz.a((Object) eventParcel);
        xz.a(str);
        c(str);
        this.a.h().a(new ahl$3(this, str2, eventParcel, str));
    }

    public void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        xz.a((Object) userAttributeParcel);
        c(appMetadata);
        if (userAttributeParcel.a() == null) {
            this.a.h().a(new ahl$5(this, appMetadata, userAttributeParcel));
        } else {
            this.a.h().a(new ahl$6(this, appMetadata, userAttributeParcel));
        }
    }

    void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.a.e().b.a(split[1], longValue);
                    } else {
                        this.a.f().z().a("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.a.f().z().a("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    public byte[] a(EventParcel eventParcel, String str) {
        Object e;
        xz.a(str);
        xz.a((Object) eventParcel);
        c(str);
        this.a.f().D().a("Log and bundle. event", eventParcel.b);
        long c = this.a.r().c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.a.h().b(new ahl$4(this, eventParcel, str)).get();
            if (bArr == null) {
                this.a.f().f().a("Log and bundle returned null");
                bArr = new byte[0];
            }
            this.a.f().D().a("Log and bundle processed. event, size, time_ms", eventParcel.b, Integer.valueOf(bArr.length), Long.valueOf((this.a.r().c() / 1000000) - c));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            this.a.f().f().a("Failed to log and bundle. event, error", eventParcel.b, e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.a.f().f().a("Failed to log and bundle. event, error", eventParcel.b, e);
            return null;
        }
    }

    public void b(AppMetadata appMetadata) {
        c(appMetadata);
        this.a.h().a(new ahl$1(this, appMetadata));
    }

    protected void b(String str) throws SecurityException {
        int myUid = this.b ? Process.myUid() : Binder.getCallingUid();
        if (!zw.a(this.a.q(), myUid, str)) {
            if (!zw.a(this.a.q(), myUid) || this.a.C()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }
}
