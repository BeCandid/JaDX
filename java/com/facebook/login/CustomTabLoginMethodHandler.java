package com.facebook.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient.Request;
import defpackage.ul;
import defpackage.vi;
import defpackage.we;
import defpackage.we$b;
import defpackage.wf;
import defpackage.wk;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<CustomTabLoginMethodHandler> CREATOR = new Creator() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public CustomTabLoginMethodHandler a(Parcel source) {
            return new CustomTabLoginMethodHandler(source);
        }

        public CustomTabLoginMethodHandler[] a(int size) {
            return new CustomTabLoginMethodHandler[size];
        }
    };
    private vi c;

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    String a() {
        return "custom_tab";
    }

    AccessTokenSource b_() {
        return AccessTokenSource.CHROME_CUSTOM_TAB;
    }

    boolean a(Request request) {
        if (!c()) {
            return false;
        }
        Bundle parameters = a(b(request), request);
        Activity activity = this.b.b();
        this.c = new vi("oauth", parameters);
        this.c.a(activity);
        return true;
    }

    protected void a(JSONObject param) throws JSONException {
        if (this.b.a() instanceof wk) {
            param.put("7_challenge", ((wk) this.b.a()).a());
        }
    }

    private boolean c() {
        return e() && a(this.b.b()) && wf.c(ul.f());
    }

    private boolean a(Context context) {
        Intent serviceIntent = new Intent("android.support.customtabs.action.CustomTabsService");
        serviceIntent.setPackage("com.android.chrome");
        List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentServices(serviceIntent, 0);
        if (resolveInfos == null || resolveInfos.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean e() {
        we$b settings = we.d(we.a(this.b.b()));
        return settings != null && settings.d();
    }

    public int describeContents() {
        return 0;
    }

    CustomTabLoginMethodHandler(Parcel source) {
        super(source);
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }
}
