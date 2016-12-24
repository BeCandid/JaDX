package defpackage;

import android.content.Context;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import java.util.concurrent.Callable;

/* compiled from: FacebookSdk */
class ul$3 implements Callable<Void> {
    final /* synthetic */ ul$a a;
    final /* synthetic */ Context b;

    ul$3(ul$a ul_a, Context context) {
        this.a = ul_a;
        this.b = context;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        uh.a().c();
        ur.a().c();
        if (AccessToken.a() != null && Profile.a() == null) {
            Profile.b();
        }
        if (this.a != null) {
            this.a.a();
        }
        AppEventsLogger.a(this.b.getApplicationContext()).b();
        return null;
    }
}
