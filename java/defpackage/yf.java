package defpackage;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R;

public class yf {
    private final Resources a;
    private final String b = this.a.getResourcePackageName(R.string.common_google_play_services_unknown_issue);

    public yf(Context context) {
        xz.a((Object) context);
        this.a = context.getResources();
    }

    public String a(String str) {
        int identifier = this.a.getIdentifier(str, "string", this.b);
        return identifier == 0 ? null : this.a.getString(identifier);
    }
}
