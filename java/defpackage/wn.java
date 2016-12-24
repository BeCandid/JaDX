package defpackage;

import com.facebook.AccessToken;
import java.util.Set;

/* compiled from: LoginResult */
public class wn {
    private final AccessToken a;
    private final Set<String> b;
    private final Set<String> c;

    public wn(AccessToken accessToken, Set<String> recentlyGrantedPermissions, Set<String> recentlyDeniedPermissions) {
        this.a = accessToken;
        this.b = recentlyGrantedPermissions;
        this.c = recentlyDeniedPermissions;
    }

    public AccessToken a() {
        return this.a;
    }

    public Set<String> b() {
        return this.b;
    }
}
