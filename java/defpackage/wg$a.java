package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;

/* compiled from: WebDialog */
public class wg$a {
    private Context a;
    private String b;
    private String c;
    private int d;
    private wg$c e;
    private Bundle f;
    private AccessToken g;

    public wg$a(Context context, String action, Bundle parameters) {
        this.g = AccessToken.a();
        if (this.g == null) {
            String applicationId = we.a(context);
            if (applicationId != null) {
                this.b = applicationId;
            } else {
                throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
            }
        }
        a(context, action, parameters);
    }

    public wg$a(Context context, String applicationId, String action, Bundle parameters) {
        if (applicationId == null) {
            applicationId = we.a(context);
        }
        wf.a(applicationId, "applicationId");
        this.b = applicationId;
        a(context, action, parameters);
    }

    public wg$a a(wg$c listener) {
        this.e = listener;
        return this;
    }

    public wg a() {
        if (this.g != null) {
            this.f.putString("app_id", this.g.h());
            this.f.putString("access_token", this.g.b());
        } else {
            this.f.putString("app_id", this.b);
        }
        return new wg(this.a, this.c, this.f, this.d, this.e);
    }

    public String b() {
        return this.b;
    }

    public Context c() {
        return this.a;
    }

    public int d() {
        return this.d;
    }

    public Bundle e() {
        return this.f;
    }

    public wg$c f() {
        return this.e;
    }

    private void a(Context context, String action, Bundle parameters) {
        this.a = context;
        this.c = action;
        if (parameters != null) {
            this.f = parameters;
        } else {
            this.f = new Bundle();
        }
    }
}
