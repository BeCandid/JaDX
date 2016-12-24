package defpackage;

import android.content.Context;
import android.text.TextUtils;

public final class ahw {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    private ahw(String str, String str2, String str3, String str4, String str5, String str6) {
        xz.a(!zv.a(str), (Object) "ApplicationId must be set.");
        this.b = str;
        this.a = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public static ahw a(Context context) {
        yf yfVar = new yf(context);
        Object a = yfVar.a("google_app_id");
        return TextUtils.isEmpty(a) ? null : new ahw(a, yfVar.a("google_api_key"), yfVar.a("firebase_database_url"), yfVar.a("ga_trackingId"), yfVar.a("gcm_defaultSenderId"), yfVar.a("google_storage_bucket"));
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ahw)) {
            return false;
        }
        ahw ahw = (ahw) obj;
        return zc.a(this.b, ahw.b) && zc.a(this.a, ahw.a) && zc.a(this.c, ahw.c) && zc.a(this.d, ahw.d) && zc.a(this.e, ahw.e) && zc.a(this.f, ahw.f);
    }

    public int hashCode() {
        return zc.a(this.b, this.a, this.c, this.d, this.e, this.f);
    }

    public String toString() {
        return zc.a((Object) this).a("applicationId", this.b).a("apiKey", this.a).a("databaseUrl", this.c).a("gcmSenderId", this.e).a("storageBucket", this.f).toString();
    }
}
