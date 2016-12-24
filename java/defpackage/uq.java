package defpackage;

import android.content.SharedPreferences;
import com.facebook.Profile;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProfileCache */
final class uq {
    private final SharedPreferences a = ul.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    uq() {
    }

    Profile a() {
        String jsonString = this.a.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (jsonString != null) {
            try {
                return new Profile(new JSONObject(jsonString));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    void a(Profile profile) {
        wf.a((Object) profile, "profile");
        JSONObject jsonObject = profile.d();
        if (jsonObject != null) {
            this.a.edit().putString("com.facebook.ProfileManager.CachedProfile", jsonObject.toString()).apply();
        }
    }

    void b() {
        this.a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}
