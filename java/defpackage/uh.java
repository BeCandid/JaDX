package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.AccessToken;
import com.facebook.AccessToken.a;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.b;
import com.facebook.HttpMethod;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AccessTokenManager */
public final class uh {
    private static volatile uh a;
    private final bn b;
    private final ug c;
    private AccessToken d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private Date f = new Date(0);

    uh(bn localBroadcastManager, ug accessTokenCache) {
        wf.a((Object) localBroadcastManager, "localBroadcastManager");
        wf.a((Object) accessTokenCache, "accessTokenCache");
        this.b = localBroadcastManager;
        this.c = accessTokenCache;
    }

    public static uh a() {
        if (a == null) {
            synchronized (uh.class) {
                if (a == null) {
                    a = new uh(bn.a(ul.f()), new ug());
                }
            }
        }
        return a;
    }

    public AccessToken b() {
        return this.d;
    }

    boolean c() {
        AccessToken accessToken = this.c.a();
        if (accessToken == null) {
            return false;
        }
        a(accessToken, false);
        return true;
    }

    public void a(AccessToken currentAccessToken) {
        a(currentAccessToken, true);
    }

    private void a(AccessToken currentAccessToken, boolean saveToCache) {
        AccessToken oldAccessToken = this.d;
        this.d = currentAccessToken;
        this.e.set(false);
        this.f = new Date(0);
        if (saveToCache) {
            if (currentAccessToken != null) {
                this.c.a(currentAccessToken);
            } else {
                this.c.b();
                we.b(ul.f());
            }
        }
        if (!we.a((Object) oldAccessToken, (Object) currentAccessToken)) {
            a(oldAccessToken, currentAccessToken);
        }
    }

    private void a(AccessToken oldAccessToken, AccessToken currentAccessToken) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", oldAccessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", currentAccessToken);
        this.b.a(intent);
    }

    public void d() {
        if (e()) {
            a(null);
        }
    }

    private boolean e() {
        if (this.d == null) {
            return false;
        }
        Long now = Long.valueOf(new Date().getTime());
        if (!this.d.f().a() || now.longValue() - this.f.getTime() <= 3600000 || now.longValue() - this.d.g().getTime() <= 86400000) {
            return false;
        }
        return true;
    }

    private static GraphRequest a(AccessToken accessToken, b callback) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), HttpMethod.GET, callback);
    }

    private static GraphRequest b(AccessToken accessToken, b callback) {
        Bundle parameters = new Bundle();
        parameters.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, "oauth/access_token", parameters, HttpMethod.GET, callback);
    }

    void a(a callback) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            b(callback);
        } else {
            new Handler(Looper.getMainLooper()).post(new uh$1(this, callback));
        }
    }

    private void b(a callback) {
        AccessToken accessToken = this.d;
        if (accessToken == null) {
            if (callback != null) {
                callback.a(new FacebookException("No current access token to refresh"));
            }
        } else if (this.e.compareAndSet(false, true)) {
            this.f = new Date();
            Set<String> permissions = new HashSet();
            Set<String> declinedPermissions = new HashSet();
            un batch = new un(uh.a(accessToken, new uh$2(this, new AtomicBoolean(false), permissions, declinedPermissions)), uh.b(accessToken, new uh$3(this, new uh$a())));
            batch.a(new uh$4(this, accessToken, callback, permissionsCallSucceeded, refreshResult, permissions, declinedPermissions));
            batch.h();
        } else if (callback != null) {
            callback.a(new FacebookException("Refresh already in progress"));
        }
    }
}
