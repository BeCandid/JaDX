package defpackage;

import android.app.Activity;
import android.os.Bundle;
import com.crashlytics.android.answers.SessionEvent.Type;

/* compiled from: AnswersLifecycleCallbacks */
class rq extends akv$b {
    private final sf a;
    private final rt b;

    public rq(sf analyticsManager, rt backgroundManager) {
        this.a = analyticsManager;
        this.b = backgroundManager;
    }

    public void a(Activity activity, Bundle bundle) {
    }

    public void a(Activity activity) {
        this.a.a(activity, Type.a);
    }

    public void b(Activity activity) {
        this.a.a(activity, Type.b);
        this.b.a();
    }

    public void c(Activity activity) {
        this.a.a(activity, Type.c);
        this.b.b();
    }

    public void d(Activity activity) {
        this.a.a(activity, Type.d);
    }

    public void b(Activity activity, Bundle bundle) {
    }

    public void e(Activity activity) {
    }
}
