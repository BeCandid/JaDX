package defpackage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.location.DetectedActivity;

/* compiled from: ActivityStore */
public class aom {
    private static final String a = (aom.class.getCanonicalName() + ".KEY");
    private SharedPreferences b;

    public void a(String id, DetectedActivity activity) {
        Editor editor = this.b.edit();
        editor.putInt(a(id, "ACTIVITY"), activity.a());
        editor.putInt(a(id, "CONFIDENCE"), activity.b());
        editor.putInt(a(id, "VERSION_CODE"), activity.c());
        editor.apply();
    }

    private String a(String id, String field) {
        return a + "_" + id + "_" + field;
    }
}
