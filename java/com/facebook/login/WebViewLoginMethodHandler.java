package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.login.LoginClient.Request;
import defpackage.vm;
import defpackage.wg;
import defpackage.wg$a;
import defpackage.wg$c;

class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<WebViewLoginMethodHandler> CREATOR = new Creator() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public WebViewLoginMethodHandler a(Parcel source) {
            return new WebViewLoginMethodHandler(source);
        }

        public WebViewLoginMethodHandler[] a(int size) {
            return new WebViewLoginMethodHandler[size];
        }
    };
    private wg c;
    private String d;

    static class a extends wg$a {
        private String a;
        private boolean b;

        public a(Context context, String applicationId, Bundle parameters) {
            super(context, applicationId, "oauth", parameters);
        }

        public a a(String e2e) {
            this.a = e2e;
            return this;
        }

        public a a(boolean isRerequest) {
            this.b = isRerequest;
            return this;
        }

        public wg a() {
            Bundle parameters = e();
            parameters.putString("redirect_uri", "fbconnect://success");
            parameters.putString("client_id", b());
            parameters.putString("e2e", this.a);
            parameters.putString("response_type", "token,signed_request");
            parameters.putString("return_scopes", "true");
            parameters.putString("auth_type", "rerequest");
            return new wg(c(), "oauth", parameters, d(), f());
        }
    }

    WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    String a() {
        return "web_view";
    }

    AccessTokenSource b_() {
        return AccessTokenSource.WEB_VIEW;
    }

    boolean d() {
        return true;
    }

    void b() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    boolean a(final Request request) {
        Bundle parameters = b(request);
        wg$c listener = new wg$c(this) {
            final /* synthetic */ WebViewLoginMethodHandler b;

            public void a(Bundle values, FacebookException error) {
                this.b.b(request, values, error);
            }
        };
        this.d = LoginClient.m();
        a("e2e", this.d);
        FragmentActivity fragmentActivity = this.b.b();
        this.c = new a(fragmentActivity, request.d(), parameters).a(this.d).a(request.f()).a(listener).a();
        vm dialogFragment = new vm();
        dialogFragment.setRetainInstance(true);
        dialogFragment.a(this.c);
        dialogFragment.show(fragmentActivity.getSupportFragmentManager(), "FacebookDialogFragment");
        return true;
    }

    void b(Request request, Bundle values, FacebookException error) {
        super.a(request, values, error);
    }

    WebViewLoginMethodHandler(Parcel source) {
        super(source);
        this.d = source.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.d);
    }
}
