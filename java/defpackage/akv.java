package defpackage;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: ActivityLifecycleManager */
public class akv {
    private final Application a;
    private akv$a b;

    public akv(Context context) {
        this.a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.b = new akv$a(this.a);
        }
    }

    public boolean a(akv$b callbacks) {
        return this.b != null && this.b.a(callbacks);
    }

    public void a() {
        if (this.b != null) {
            this.b.a();
        }
    }
}
